/*******************************************************************************
 * Copyright (c) 2011, 2012 Red Hat, Inc. 
 * All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 *******************************************************************************/
package org.eclipse.bpmn2.modeler.runtime.automatiko.util;

import java.util.Hashtable;
import java.util.List;

import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Import;
import org.eclipse.bpmn2.Interface;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.ItemKind;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.Property;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesAdapter;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesProvider;
import org.eclipse.bpmn2.modeler.core.model.Bpmn2ModelerFactory;
import org.eclipse.bpmn2.modeler.core.model.ModelDecorator;
import org.eclipse.bpmn2.modeler.core.utils.ImportUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionFactory;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.ItemDefinitionPropertiesAdapter;
import org.eclipse.bpmn2.modeler.ui.property.dialogs.DefaultSchemaImportDialog;
import org.eclipse.bpmn2.modeler.ui.property.dialogs.SchemaImportDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AutomatikoModelUtil {

	public static class ImportHandler extends ImportUtil {
		private boolean createVariables = false;
		private IType importedType = null;
		
	    public Interface createInterface(Definitions definitions, Import imp, IType type, IMethod[] methods) {
	    	importedType = type;
	    	return super.createInterface(definitions, imp, type, methods);
	    }
	    
		public ItemDefinition createItemDefinition(Definitions definitions, Import imp, IType clazz) {
			ItemDefinition itemDef = null;
			if (clazz!=importedType) {
				itemDef = findItemDefinition(definitions, imp, clazz);
				if (itemDef==null) {
					itemDef = super.createItemDefinition(definitions, imp, clazz);
					AutomatikoModelUtil.addImport(clazz, itemDef, false, createVariables);
					
					// create process variables for referenced types only, not the containing class
					if (createVariables) {
						List<Process> processes = ModelUtil.getAllRootElements(definitions, Process.class);
						if (processes.size()>0) {
							Process process = processes.get(0);
							String structName = clazz.getElementName();
							int index = structName.lastIndexOf("."); //$NON-NLS-1$
							if (index>0)
								structName = structName.substring(index+1);
							String varName = structName + "Var"; //$NON-NLS-1$
							index = 1;
							boolean done;
							do {
								done = true;
								for (Property p : process.getProperties()) {
									if (varName.equals(p.getName())) {
										varName = structName + "Var" + index++;  //$NON-NLS-1$
										done = false;
										break;
									}
								}
							} while (!done);
							Resource resource = ExtendedPropertiesAdapter.getResource(definitions);
							Property var = Bpmn2ModelerFactory.createFeature(resource, processes.get(0), "properties", Property.class); //$NON-NLS-1$
							var.setName(varName);
							var.setId(varName);
							var.setItemSubjectRef(itemDef);
						}
					}
				}
			}
			return itemDef;
		}

		public void setCreateVariables(boolean createVariables) {
			this.createVariables = createVariables;
		}
	}
	
	/**
	 * Helper method to display a Java class import dialog and create a new ImportType. This method
	 * will also create a corresponding ItemDefinition for the newly imported java type.
	 * 
	 * @param object - a context EObject used to search for the Process in which the new
	 *                 ImportType will be created.
	 * @return an ImportType object if it was created, null if the user canceled the import dialog.
	 */
	public static Object showImportDialog(EObject object) {
		Shell shell = Display.getDefault().getActiveShell();
		DefaultSchemaImportDialog dialog = new DefaultSchemaImportDialog(shell, SchemaImportDialog.ALLOW_JAVA);
		if (dialog.open() == Window.OK) {
			Object result[] = dialog.getResult();
			if (result.length == 1 && result[0] instanceof IType) {
				return (IType) result[0];
			} else if (result.length == 1) {
				return result[0];
			}
		}
		return null;
	}
	
	public static ImportType addImport(final IType type, final EObject object) {
		return addImport(type,object,true,false);
	}
	
	public static ImportType addImport(final IType type, final EObject object,
			final boolean recursive, final boolean createVariables) {
		if (type==null)
			return null;
		
		final Definitions definitions = ModelUtil.getDefinitions(object);
		if (definitions==null)
			return null;
		
		Process process = null;
		if (object instanceof Process)
			process = (Process)object;
		else {
			process = (Process) ModelUtil.findNearestAncestor(object, new Class[] { Process.class });
			if (process==null) {
				List<Process> processes = ModelUtil.getAllRootElements(definitions, Process.class);
				if (processes.size()>1) {
					// TODO: allow user to pick one?
					process = processes.get(0);
				}
				else if (processes.size()==1)
					process = processes.get(0);
				else {
					if (recursive) {
						Shell shell = Display.getDefault().getActiveShell();
						MessageDialog.openError(shell, Messages.AutomatikoModelUtil_No_Process_Title, Messages.AutomatikoModelUtil_No_Process_Message);
					}
					return null;
				}
			}
		}
		
		final String className = type.getFullyQualifiedName('.');
		List<ImportType> allImports = ModelDecorator.getAllExtensionAttributeValues(process, ImportType.class);
		for (ImportType it : allImports) {
			if (className.equals(it.getName())) {
				if (recursive) {
					Shell shell = Display.getDefault().getActiveShell();
					MessageDialog.openWarning(shell, Messages.AutomatikoModelUtil_Duplicate_Import_Title,
						NLS.bind(
							Messages.AutomatikoModelUtil_Duplicate_Import_Message,className
						)
					);
				}
				return null;
			}
		}
		
		final Process fProcess = process;
		final ImportType newImport = ExtensionFactory.eINSTANCE.createImportType();
		newImport.setName(className);

		TransactionalEditingDomain domain = ModelUtil.getEditor(object).getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				
				ImportHandler importer = new ImportHandler();
				importer.setCreateVariables(createVariables);
				
				ModelDecorator.addExtensionAttributeValue(fProcess.eResource(), fProcess,
						ExtensionPackage.eINSTANCE.getDocumentRoot_ImportType(), newImport);
				
				if (recursive) {
					if (object instanceof ItemDefinition) {
						// update the ItemDefinition passed to us
						ItemDefinition oldItemDef = (ItemDefinition)object;
						// and now update the existing item's structureRef
						oldItemDef.setItemKind(ItemKind.INFORMATION);
						EObject structureRef = ModelUtil.createStringWrapper(className);
						oldItemDef.setStructureRef(structureRef);
					}
					else {
						// create a new ItemDefinition
						importer.createItemDefinition(definitions, null, type);
					}
				}
			}
		});
		
		return newImport;
	}

	public static void removeImport(ImportType importType) {
		Definitions definitions = ModelUtil.getDefinitions(importType);
		Import imp = Bpmn2ModelerFactory.createObject(definitions.eResource(), Import.class);
		imp.setImportType(ImportUtil.IMPORT_TYPE_JAVA);
		imp.setLocation(importType.getName());
		definitions.getImports().add(imp);
		ImportHandler.removeImport(imp);
	}
	
	/**
	 * This method compiles a list of all known "data types" (a.k.a. ItemDefinitions) that
	 * are in scope for the given context element.
	 * 
	 * There are 4 different places to look:
	 * 1. the Data Type registry, which contains a list of all known "native" types, e.g. java
	 *    Strings, Integers, etc.
	 * 2. the list of ImportType extension values in the Process ancestor nearest to the given
	 *    context object.
	 * 3. the list of GlobalType extension values, also in the nearest Process ancestor
	 * 4. the list of ItemDefinitions in the root elements.
	 * 
	 * @param object - a context EObject used to search for ItemDefinitions, Globals and Imports
	 * @return a map of Strings and Objects representing the various data types
	 */
	public static Hashtable<String, Object> getChoiceOfValues(EObject object) {

//		Hashtable<String,Object> choices = new Hashtable<String,Object>();
//		Definitions definitions = ModelUtil.getDefinitions(object);
//
//		// add all native types (as defined in the DataTypeRegistry)
//		DataTypeRegistry.getFactory("dummy"); //$NON-NLS-1$
//		for (Entry<String, DataTypeFactory> e : DataTypeRegistry.instance.entrySet()) {
//			DataType dt = e.getValue().createDataType();
//			if (dt instanceof EnumDataType || dt instanceof UndefinedDataType)
//				continue;
//			String dts = dt.getStringType();
//			
//			ItemDefinition itemDef = null;
//			List<ItemDefinition> itemDefs = ModelUtil.getAllRootElements(definitions, ItemDefinition.class);
//			for (ItemDefinition id : itemDefs) {
//				String ids = ModelUtil.getStringWrapperValue(id.getStructureRef());
//				if (ids==null || ids.isEmpty())
//					ids = id.getId();
//				if (ids.equals(dts)) {
//					itemDef = id;
//					break;
//				}
//			}
//			if (itemDef==null) {
//				// create a new ItemDefinition for the jBPM data type
//				itemDef = Bpmn2ModelerFactory.create(ItemDefinition.class);
//				itemDef.setItemKind(ItemKind.INFORMATION);
//				itemDef.setStructureRef(ModelUtil.createStringWrapper(dts));
//				itemDef.setId("_"+dts); //$NON-NLS-1$
//				if (definitions!=null) {
//					InsertionAdapter.add(definitions, Bpmn2Package.eINSTANCE.getDefinitions_RootElements(), itemDef);
//				}
//			}
//			choices.put(dt.getStringType(),itemDef);
//		}
//		
//		// add all imported data types
//		EObject process = object;
//		while (process!=null && !(process instanceof org.eclipse.bpmn2.Process))
//			process = process.eContainer();
//		if (process==null) {
//			List<Process> list = ModelUtil.getAllRootElements(definitions, Process.class);
//			if (list.size()>0)
//				process = list.get(0);
//		}
//		
//		String s;
//		List<ImportType> imports = ModelDecorator.getAllExtensionAttributeValues(process, ImportType.class);
//		for (ImportType it : imports) {
//			s = it.getName();
//			if (s!=null && !s.isEmpty())
//				choices.put(s, it);
//		}
//		
//		// add all Global variable types
//		List<GlobalType> globals = ModelDecorator.getAllExtensionAttributeValues(process, GlobalType.class);
//		for (GlobalType gt : globals) {
//			s = gt.getType();
//			if (s!=null && !s.isEmpty())
//				choices.put(s, gt);
//		}
//
//		// add all ItemDefinitions
//		choices.putAll( ItemDefinitionPropertiesAdapter.getChoiceOfValues(object) );
//		
//		return choices;
		
		return ItemDefinitionPropertiesAdapter.getChoiceOfValues(object);
	}
	
	/**
	 * This method returns a string representation for a "data type". This is intended to
	 * be used to interpret the various objects in the map returned by getChoiceOfValues().
	 * 
	 * @param value - one of the Object values in the map returned by getChoiceOfValues().
	 * @return a string representation of the data type
	 */
	public static String getDataType(Object value) {
		String stringValue = null;
		if (value instanceof String) {
			stringValue = (String)value;
		}
//		else if (value instanceof DataType) {
//			stringValue = ((DataType)value).getStringType();
//		}
		else if (value instanceof ImportType) {
			stringValue = ((ImportType)value).getName();
		}
		else if (value instanceof ItemDefinition) {
			stringValue = ExtendedPropertiesProvider.getTextValue((ItemDefinition)value);
		}
		return stringValue;
	}
	
	/**
	 * This method returns an ItemDefinition object for a "data type". This is intended to
	 * be used to interpret the various objects in the map returned by getChoiceOfValues().
	 * 
	 * NOTE: This method will create an ItemDefinition if it does not already exist.
	 * 
	 * @param be - a context EObject used to search for ItemDefinitions, and to create
	 *                 new ItemDefinitions if necessary.
	 * @param value - one of the Object values in the map returned by getChoiceOfValues().
	 * @return an ItemDefinition for the data type
	 */
	public static ItemDefinition getDataType(EObject context, Object value) {
		ItemDefinition itemDef = null;
		if (value instanceof String) {
			itemDef = findOrCreateItemDefinition( context, (String)value );
		}
//		else if (value instanceof DataType) {
//			itemDef = findOrCreateItemDefinition( context, ((DataType)value).getStringType() );
//		}
		else if (value instanceof ImportType) {
			itemDef = findOrCreateItemDefinition( context, ((ImportType)value).getName() );
		}
		else if (value instanceof ItemDefinition) {
			itemDef = (ItemDefinition)value;
		}
		return itemDef;
	}
	
	public static ItemDefinition findOrCreateItemDefinition(EObject context, String structureRef) {
		ItemDefinition itemDef = null;
		Resource resource = ExtendedPropertiesAdapter.getResource(context);
		Definitions definitions = ModelUtil.getDefinitions(resource);
		List<ItemDefinition> itemDefs = ModelUtil.getAllRootElements(definitions, ItemDefinition.class);
		for (ItemDefinition id : itemDefs) {
			String s = ModelUtil.getStringWrapperTextValue(id.getStructureRef());
			if (s!=null && s.equals(structureRef)) {
				itemDef = id;
				break;
			}
		}
		if (itemDef==null)
		{
			itemDef = Bpmn2ModelerFactory.createObject(resource, ItemDefinition.class);
			itemDef.setStructureRef(ModelUtil.createStringWrapper(structureRef));
			itemDef.setItemKind(ItemKind.INFORMATION);

			ModelUtil.setID(itemDef);
		}
		return itemDef;
	}
	
	public static String getVariableReference(String text) {
		if (text.startsWith("#{") && text.endsWith("}")) {
			String var = text.substring(2, text.length()-1);
			if (!var.isEmpty())
				return var;
		}
		return null;
	}

	public static boolean isProcessId(String id) {
		String var = AutomatikoModelUtil.getVariableReference(id);
		if (var!=null) {
			// It's a variable reference.
			// Still need to validate if variable is actually defined;
			// this is done in batch validation.
			return true;
		}

		for (char c : id.toCharArray()) {
			if (c!='_' && !Character.isLetterOrDigit(c) && c!='-' && c!=':' && c!='.') {
				return false;
			}
		}
		return true;
	}
	
	public static String toProcessId(String text) {
		String id = "";
		for (char c : text.toCharArray()) {
			if (c!='_' && !Character.isLetterOrDigit(c) && c!='-' && c!=':' && c!='.') {
				c = '_';
			}
			id += c;
		}
		return id;
	}
}
