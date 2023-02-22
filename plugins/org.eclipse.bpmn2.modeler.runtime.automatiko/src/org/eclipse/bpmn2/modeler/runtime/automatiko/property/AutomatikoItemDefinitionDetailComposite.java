/*******************************************************************************
 * Copyright (c) 2011, 2012, 2013 Red Hat, Inc.
 * All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.bpmn2.modeler.runtime.automatiko.property;

import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.ItemKind;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesProvider;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.ObjectEditor;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.TextObjectEditor;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.property.diagrams.ItemDefinitionDetailComposite;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Composite;

public class AutomatikoItemDefinitionDetailComposite extends
		ItemDefinitionDetailComposite {

	public AutomatikoItemDefinitionDetailComposite(Composite parent, int style) {
		super(parent, style);
	}

	public AutomatikoItemDefinitionDetailComposite(
			AbstractBpmn2PropertySection section) {
		super(section);
	}
	
	@Override
	protected void bindReference(Composite parent, EObject object, EReference reference) {
		if ("structureRef".equals(reference.getName()) && //$NON-NLS-1$
				isModelObjectEnabled(object.eClass(), reference)) {
			
			if (parent==null)
				parent = getAttributesParent();
			
			final ItemDefinition def = (ItemDefinition)object;
			String displayName = ExtendedPropertiesProvider.getLabel(object, reference);
			
			if (def.getItemKind().equals(ItemKind.INFORMATION)) {
				AutomatikoItemDefinitionStructureEditor editor = new AutomatikoItemDefinitionStructureEditor(this,object,reference);
				editor.createControl(parent,displayName);
			}
			else {
				ObjectEditor editor = new TextObjectEditor(this,object,reference) {
					@Override
					public boolean setValue(Object result) {
						return super.setValue(ModelUtil.createStringWrapper((String)result));
					}
				};
				editor.createControl(parent,displayName);
			}
		}
		else
			super.bindReference(parent, object, reference);
	}

}
