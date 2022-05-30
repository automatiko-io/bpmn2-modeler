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
package org.eclipse.bpmn2.modeler.runtime.automatiko.property;


import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoModelUtil;
import org.eclipse.bpmn2.modeler.ui.property.editors.ItemDefinitionStructureEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IType;

public class AutomatikoItemDefinitionStructureEditor extends ItemDefinitionStructureEditor {

	public AutomatikoItemDefinitionStructureEditor(AbstractDetailComposite parent, EObject object, EStructuralFeature feature) {
		super(parent, object);
	}

	@Override
	protected boolean canAdd() {
		return true;
	}
	
	@Override
	protected void buttonClicked(int buttonId) {
		if (buttonId==ID_ADD_BUTTON) {
		    IType type = (IType) AutomatikoModelUtil.showImportDialog(object);
			ImportType imp = AutomatikoModelUtil.addImport(type, object);
			if (imp!=null)
				setText(imp.getName());
		}
		else
			super.buttonClicked(buttonId);
	}
}
