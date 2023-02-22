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

import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ImportType;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

public class AutomatikomportTypeDetailComposite extends DefaultDetailComposite {

	public AutomatikomportTypeDetailComposite(Composite parent, int style) {
		super(parent, style);
	}

	public AutomatikomportTypeDetailComposite(AbstractBpmn2PropertySection section) {
		super(section);
	}

	
	@Override
	protected void bindAttribute(Composite parent, EObject object, EAttribute attribute, String label) {
		if (parent==null)
			parent = getAttributesParent();
		
		final ImportType def = (ImportType)object;
		String displayName = Messages.AutomatikoImportTypeDetailComposite_Title; //ModelUtil.getLabel(object, attribute);
		
		AutomatikoImportObjectEditor editor = new AutomatikoImportObjectEditor(this,object,attribute);
		editor.createControl(parent,displayName);
	}
}
