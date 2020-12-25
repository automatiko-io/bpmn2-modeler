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
package org.eclipse.bpmn2.modeler.runtime.automatiko.property.adapters;

import java.util.Hashtable;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.CorrelationProperty;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoModelUtil;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.CorrelationPropertyPropertiesAdapter;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.ItemDefinitionRefFeatureDescriptor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AutomatikoCorrelationPropertyPropertiesAdapter extends CorrelationPropertyPropertiesAdapter {

	public AutomatikoCorrelationPropertyPropertiesAdapter(AdapterFactory adapterFactory, CorrelationProperty object) {
		super(adapterFactory, object);

		EStructuralFeature feature = Bpmn2Package.eINSTANCE.getCorrelationProperty_Type();
		setProperty(feature, UI_IS_MULTI_CHOICE, Boolean.TRUE);
    	setFeatureDescriptor(feature, new ItemDefinitionRefFeatureDescriptor<CorrelationProperty>(this, object, feature) {

    		@Override
    		public Hashtable<String, Object> getChoiceOfValues() {
				return AutomatikoModelUtil.getChoiceOfValues(object);
    		}
	
    	});
	}

}
