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
package org.eclipse.bpmn2.modeler.runtime.automatik.property.adapters;

import java.util.Hashtable;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.JavaVariableNameObjectEditor;
import org.eclipse.bpmn2.modeler.runtime.automatik.util.AutomatikModelUtil;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.ItemDefinitionRefFeatureDescriptor;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.MessagePropertiesAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AutomatikMessagePropertiesAdapter extends MessagePropertiesAdapter {

	public AutomatikMessagePropertiesAdapter(AdapterFactory adapterFactory, Message object) {
		super(adapterFactory, object);

		EStructuralFeature feature = Bpmn2Package.eINSTANCE.getMessage_ItemRef();
		setProperty(feature, UI_IS_MULTI_CHOICE, Boolean.TRUE);
    	setFeatureDescriptor(feature, new ItemDefinitionRefFeatureDescriptor<Message>(this, object, feature) {

			@Override
    		public Hashtable<String, Object> getChoiceOfValues() {
				return AutomatikModelUtil.getChoiceOfValues(object);
    		}
	
    	});

		feature = Bpmn2Package.eINSTANCE.getMessage_Name();
		setProperty(feature, UI_OBJECT_EDITOR_CLASS, JavaVariableNameObjectEditor.class);
	}

}
