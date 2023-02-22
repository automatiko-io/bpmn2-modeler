/*******************************************************************************
 * Copyright (c) 2011, 2012 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/

package org.eclipse.bpmn2.modeler.runtime.automatiko.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Expression;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.InputOutputSpecification;
import org.eclipse.bpmn2.InputSet;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.ItemKind;
import org.eclipse.bpmn2.OutputSet;
import org.eclipse.bpmn2.PotentialOwner;
import org.eclipse.bpmn2.ResourceAssignmentExpression;
import org.eclipse.bpmn2.ResourceRole;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesAdapter;
import org.eclipse.bpmn2.modeler.core.adapters.InsertionAdapter;
import org.eclipse.bpmn2.modeler.core.features.CustomElementFeatureContainer;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractListComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultListComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultPropertiesCompositeFactory;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.IPropertiesCompositeFactory;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.ListCompositeColumnProvider;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.ListCompositeContentProvider;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.TableColumn;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.ObjectEditingDialog;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.ReadonlyTextObjectEditor;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.TextObjectEditor;
import org.eclipse.bpmn2.modeler.core.runtime.ModelExtensionDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.ModelExtensionDescriptor.Property;
import org.eclipse.bpmn2.modeler.core.runtime.TargetRuntime;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.property.tasks.IoParameterMappingColumn;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class AutomatikoTaskDetailComposite extends AutomatikoActivityDetailComposite {

	class DataInputOutputEditor extends ReadonlyTextObjectEditor {

		private String name;
		private Task task;
		
		public DataInputOutputEditor(Task task, ItemAwareElement parameter) {
			super (AutomatikoTaskDetailComposite.this, parameter,
					parameter instanceof DataInput ? PACKAGE.getDataInput_Name() : PACKAGE.getDataOutput_Name());
			name = (String) parameter.eGet(this.feature);
			this.task = task;
		}
		
		@Override
		protected String getText() {
			EStructuralFeature f = object instanceof DataInput ?
					PACKAGE.getActivity_DataInputAssociations() :
					PACKAGE.getActivity_DataOutputAssociations();
			IoParameterMappingColumn col = new IoParameterMappingColumn(task,f);
			return col.getText(object);
		}

		@Override
		protected void buttonClicked(int buttonId) {
			ObjectEditingDialog dialog = new ObjectEditingDialog(getDiagramEditor(), object);
			IPropertiesCompositeFactory factory = new DefaultPropertiesCompositeFactory() {
				@Override
				public AbstractDetailComposite createDetailComposite(Class eClass, Composite parent, TargetRuntime targetRuntime, int style) {
					AutomatikoDataAssociationDetailComposite composite = new AutomatikoDataAssociationDetailComposite(parent, SWT.NONE);
					if (object instanceof DataInput)
						composite.setShowToGroup(false);
					else
						composite.setShowFromGroup(false);
					return composite;
				}
			};
			if (object instanceof DataInput)
				dialog.setTitle("Edit Source for Input Parameter \""+ModelUtil.toCanonicalString(name)+"\"");
			else
				dialog.setTitle("Edit Destination for Output Parameter \""+ModelUtil.toCanonicalString(name)+"\"");
			dialog.setCompositeFactory(factory);
			if (dialog.open() == Window.OK) {
				// this just forces an update of the editor text field
				setValue(object.eGet(feature));
			}
		}

	};

	/**
	 * @param section
	 */
	public AutomatikoTaskDetailComposite(AbstractBpmn2PropertySection section) {
		super(section);
	}

	public AutomatikoTaskDetailComposite(Composite parent, int style) {
		super(parent, style);
	}
		
	@Override
	public void cleanBindings() {
		super.cleanBindings();
	}

	@Override
	protected boolean isModelObjectEnabled(String className, String featureName) {
		if ("DataInput".equals(className)) //$NON-NLS-1$
			return true;
		return super.isModelObjectEnabled(className, featureName);
	}

	@Override
	public void createBindings(EObject be) {
		createInputParameterBindings((Task)be);
		super.createBindings(be);
	}
	
	/**
	 * Create Object Editors for each of the Task's input parameters (DataInputs) that are
	 * defined in the extension plugin.xml
	 * 
	 * The mappings for these parameters are simply text expressions and will be rendered
	 * as individual editable fields on the Task property tab instead of being included in
	 * the I/O Parameters list.
	 * 
	 * @param task
	 */
	protected void createInputParameterBindings(final Task task) {

		// Get the Model Extension Descriptor for this Custom Task.
		// This will contain the Data Inputs and Outputs that were
		// defined for the Custom Task either in the plugin.xml
		// or by way of Work Item Definition files contained in
		// the project or the project's classpath.
		ModelExtensionDescriptor med = null;
		ExtendedPropertiesAdapter<?> adapter = ExtendedPropertiesAdapter.adapt(task);
		if (adapter!=null) {
			// look for it in the property adapter first
			med = adapter.getProperty(ModelExtensionDescriptor.class);
		}

		if (med==null) {
			// not found? get the Custom Task ID from the Task object
			String id = CustomElementFeatureContainer.findId(task);
			if (id!=null) {
				// and look it up in the Target Runtime's list of
				// Custom Task Descriptors
		    	TargetRuntime rt = TargetRuntime.getRuntime(task);
		    	med = rt.getCustomTask(id);
			}
		}
		
		if (med!=null) {
			// This Task object has additional properties defined either by way of the
			// <modelExtension> defined in the plugin.xml or in Work Item Definitions.
			// Check if any of the extension properties extend the DataInputs or DataOutputs
			// (i.e. the I/O Parameter mappings) and create Object Editors for them.
			// If the Task does not define these parameter mappings, create temporary objects
			// for the editors (these will go away if they are not touched by the user)
			InputOutputSpecification ioSpec = task.getIoSpecification();
			if (ioSpec==null) {
				ioSpec = createModelObject(InputOutputSpecification.class);
				InsertionAdapter.add(task,
						PACKAGE.getActivity_IoSpecification(),
						ioSpec);
			}
			
			List<Property> props = med.getProperties("ioSpecification/dataInputs/name"); //$NON-NLS-1$
			for (Property property : props) {
				
				// this will become the label for the Object Editor
				final String name = property.getFirstStringValue();
				// the input parameter
				ItemAwareElement parameter = createInputOutputParameter(task, ioSpec, name, true);
				
				// create a read-only text field and object editor button for this parameter
				DataInputOutputEditor editor = new DataInputOutputEditor(task, parameter);
				editor.createControl(getAttributesParent(),ModelUtil.toCanonicalString(name));
			}
			
			props = med.getProperties("ioSpecification/dataOutputs/name"); //$NON-NLS-1$
			for (Property property : props) {
				
				// this will become the label for the Object Editor
				final String name = property.getFirstStringValue();
				// the input parameter
				ItemAwareElement parameter = createInputOutputParameter(task, ioSpec, name, false);
				
				// create a read-only text field and object editor button for this parameter
				DataInputOutputEditor editor = new DataInputOutputEditor(task, parameter);
				editor.createControl(getAttributesParent(),ModelUtil.toCanonicalString(name));
			}
		}
	}

	private ItemAwareElement createInputOutputParameter(Task task, InputOutputSpecification ioSpec, String name, boolean isInput) {
        Definitions definitions = ModelUtil.getDefinitions(task);

		ItemAwareElement parameter = null;
		DataAssociation association = null;
		if (isInput) {
			for (DataInput input : ioSpec.getDataInputs()) {
				if (name.equals(input.getName())) {
					// this is the one!
					parameter = input;
					for (DataAssociation da : task.getDataInputAssociations()) {
						if (da.getTargetRef() == input) {
							association = da;
							break;
						}
					}
					break;
				}
			}
		}
		else {
			for (DataOutput output : ioSpec.getDataOutputs()) {
				if (name.equals(output.getName())) {
					// this is the one!
					parameter = output;
					for (DataAssociation da : task.getDataOutputAssociations()) {
						for (ItemAwareElement e : da.getSourceRef()) {
							if (e == output) {
								association = da;
								break;
							}
						}
						if (association!=null)
							break;
					}
					break;
				}
			}
		}
		if (parameter!=null)
			return parameter;
		
        ItemDefinition itemDef = createModelObject(ItemDefinition.class);
        itemDef.setItemKind(ItemKind.INFORMATION);
        itemDef.setStructureRef( ModelUtil.createStringWrapper("Object") ); //$NON-NLS-1$
        InsertionAdapter.add(definitions,
                PACKAGE.getDefinitions_RootElements(),
                itemDef);
        
		parameter = createModelObject(isInput ? DataInput.class : DataOutput.class);
		if (isInput)
			((DataInput)parameter).setName(name);
		else
			((DataOutput)parameter).setName(name);
		
		parameter.setItemSubjectRef(itemDef);
		InsertionAdapter.add(ioSpec,
				isInput ? PACKAGE.getInputOutputSpecification_DataInputs() : PACKAGE.getInputOutputSpecification_DataOutputs(),
				parameter);
		
		// create the InputSet if needed
		if (isInput) {
			InputSet inputSet = null;
			if (ioSpec.getInputSets().size()==0) {
				inputSet = createModelObject(InputSet.class);
				InsertionAdapter.add(ioSpec,
						PACKAGE.getInputOutputSpecification_InputSets(),
						inputSet);
			}
			else
				inputSet = ioSpec.getInputSets().get(0);
			// add the parameter to the InputSet also
			InsertionAdapter.add(inputSet,
					PACKAGE.getInputSet_DataInputRefs(),
					parameter);
		}
		else {
			OutputSet outputSet = null;
			if (ioSpec.getOutputSets().size()==0) {
				outputSet = createModelObject(OutputSet.class);
				InsertionAdapter.add(ioSpec,
						PACKAGE.getInputOutputSpecification_OutputSets(),
						outputSet);
			}
			else
				outputSet = ioSpec.getOutputSets().get(0);
			// add the parameter to the OutputSet also
			InsertionAdapter.add(outputSet,
					PACKAGE.getOutputSet_DataOutputRefs(),
					parameter);
		}
		

		return parameter;
	}
	
	@Override
	protected AbstractListComposite bindList(EObject object, EStructuralFeature feature, EClass listItemClass) {
		if (feature.getName().equals("resources")) { //$NON-NLS-1$
			if (isModelObjectEnabled(object.eClass(), feature)) {
				ActorsListComposite actors = new ActorsListComposite(this);
				actors.bindList(object, feature);
				actors.setTitle(Messages.AutomatikoTaskDetailComposite_Actors_Title);
				return actors;
			}
			return null;
		}
		else
			return super.bindList(object, feature, listItemClass);
	}
	
	public class ActorsNameTableColumn extends TableColumn {
		public ActorsNameTableColumn(EObject object) {
			super(object, PACKAGE.getFormalExpression_Body());
			setHeaderText(Messages.AutomatikoTaskDetailComposite_Actors_Name_Column);
			setEditable(true);
		}
	}
	
	public class ActorsListComposite extends DefaultListComposite {

		public ActorsListComposite(Composite parent) {
			super(parent, AbstractListComposite.DEFAULT_STYLE);
		}
		
		public EClass getListItemClass(EObject object, EStructuralFeature feature) {
			return PACKAGE.getFormalExpression();
		}
		
		@Override
		public ListCompositeColumnProvider getColumnProvider(EObject object, EStructuralFeature feature) {
			if (columnProvider==null) {
				columnProvider = new ListCompositeColumnProvider(this);
				columnProvider.add( new ActorsNameTableColumn(object) );
			}
			return columnProvider;
		}
		
		public ListCompositeContentProvider getContentProvider(EObject object, EStructuralFeature feature, EList<EObject>list) {
			if (contentProvider==null) {
				contentProvider = new ListCompositeContentProvider(this, object, feature, list) {
					@Override
					public Object[] getElements(Object inputElement) {
						List<Object> elements = new ArrayList<Object>();
						Task task = (Task)object;
						for (ResourceRole owner : task.getResources()) {
							ResourceAssignmentExpression resourceAssignment = owner.getResourceAssignmentExpression();
							if (resourceAssignment!=null) {
								Expression expression = resourceAssignment.getExpression();
								if (expression instanceof FormalExpression) {
									elements.add(expression);
								}
							}
						}
						return elements.toArray(); 
					}
				};
			}
			return contentProvider;
		}

		public AbstractDetailComposite createDetailComposite(Class eClass, Composite parent, int style) {
			AbstractDetailComposite composite = new DefaultDetailComposite(parent, style) {
				@Override
				protected Composite bindFeature(EObject be, EStructuralFeature feature, EClass eItemClass) {
					Composite composite = null;
					if (feature!=null && "body".equals(feature.getName())) { //$NON-NLS-1$
						super.bindFeature(be, feature, eItemClass);
					}
					return composite;
				}
				
				@Override
				protected void bindAttribute(Composite parent, EObject object, EAttribute attribute, String label) {
					TextObjectEditor editor = new TextObjectEditor(this,object,attribute);
					editor.setMultiLine(false);
					editor.createControl(parent,Messages.AutomatikoTaskDetailComposite_Actors_Name_Column);
				}
			};
			return composite;
		}

		protected EObject addListItem(EObject object, EStructuralFeature feature) {
			Task task = (Task)object;
			
			FormalExpression expression = createModelObject(FormalExpression.class);

			ResourceAssignmentExpression resourceAssignment = createModelObject(ResourceAssignmentExpression.class);
			resourceAssignment.setExpression(expression);
			PotentialOwner owner = createModelObject(PotentialOwner.class);
			owner.setResourceAssignmentExpression(resourceAssignment);
			task.getResources().add(owner);

			expression.setBody(Messages.AutomatikoTaskDetailComposite_Actors_Label);
			
			return expression;
		}
		
		protected Object removeListItem(EObject object, EStructuralFeature feature, int index) {
			Task task = (Task)object;
			int size = task.getResources().size();
			if (index>=0 && index<size) {
				task.getResources().remove(index);
			}
			return null;
		}

		@Override
		protected Object moveListItemUp(EObject object, EStructuralFeature feature, int index) {
			Task task = (Task)object;
			int size = task.getResources().size();
			if (index>0 && index<size) {
				ResourceRole owner = task.getResources().remove(index);
				task.getResources().add(index-1, owner);
				return owner;
			}
			return null;
		}

		@Override
		protected Object moveListItemDown(EObject object, EStructuralFeature feature, int index) {
			Task task = (Task)object;
			int size = task.getResources().size();
			if (index>=0 && index<size-1) {
				ResourceRole owner = task.getResources().remove(index);
				task.getResources().add(index, owner);
				return owner;
			}
			return null;
		}
	}
}
