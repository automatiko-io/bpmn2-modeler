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
package org.eclipse.bpmn2.modeler.runtime.automatik.property;

import java.util.Hashtable;

import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Interface;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.ComboObjectEditor;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatik.util.AutomatikModelUtil;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IType;

public class AutomatikImportObjectEditor extends ComboObjectEditor {

	private final Definitions definitions;

	
	public AutomatikImportObjectEditor(AbstractDetailComposite parent, EObject object, EStructuralFeature feature) {
		super(parent, object, feature);
		definitions = ModelUtil.getDefinitions(object);
	}

	@Override
	protected boolean canCreateNew() {
		return true;
	}
	
	@Override
	protected Hashtable<String, Object> getChoiceOfValues(EObject object, EStructuralFeature feature) {
		Hashtable<String, Object> choices = new Hashtable<String, Object>();
		// The object is either an Interface or ImportType, both types reference
		// a Java implementation class which may be defined in either a automatik <import>
		// or a BPMN2 <itemDefinition>.
		TreeIterator<EObject> iter = definitions.eAllContents();
		while (iter.hasNext()) {
			EObject o = iter.next();
			String choice = null;
			if (o instanceof ImportType) {
				choice = ((ImportType)o).getName();
			}
			else if (o instanceof ItemDefinition) {
				choice = ModelUtil.getStringWrapperTextValue(((ItemDefinition)o).getStructureRef());
			}
			else if (o instanceof Interface) {
				choice = ModelUtil.getStringWrapperTextValue(((Interface) o).getImplementationRef());
			}
			if (choice!=null && !choices.containsKey(choice))
				choices.put(choice, choice);
		}
		return choices;
	}

	@Override
	protected void buttonClicked(int buttonId) {
	    Object result = AutomatikModelUtil.showImportDialog(object);
	    if (result instanceof IType) {
	    	IType type = (IType) result;
	    	ImportType imp = AutomatikModelUtil.addImport(type, object);
	    	if (imp!=null)
	    		setValue(imp.getName());
	    } else if (result instanceof String) {
	    	setValue(result);
	    }
	}
}
