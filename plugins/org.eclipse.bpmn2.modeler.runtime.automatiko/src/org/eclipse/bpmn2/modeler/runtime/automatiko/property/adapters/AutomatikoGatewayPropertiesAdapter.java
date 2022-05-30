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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.GatewayDirection;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesAdapter;
import org.eclipse.bpmn2.modeler.core.adapters.FeatureDescriptor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AutomatikoGatewayPropertiesAdapter extends
		ExtendedPropertiesAdapter<Gateway> {

	public AutomatikoGatewayPropertiesAdapter(AdapterFactory adapterFactory,
			Gateway object) {
		super(adapterFactory, object);

    	EStructuralFeature ref;
    	
    	ref = Bpmn2Package.eINSTANCE.getGateway_GatewayDirection();
    	setFeatureDescriptor(ref, new FeatureDescriptor<Gateway>(this,object,ref) {

    		@Override
    		public Hashtable<String, Object> getChoiceOfValues() {
    			Hashtable<String, Object> choices = super.getChoiceOfValues();
				List<String> keys = new ArrayList<String>();
				for (Entry<String, Object> entry : choices.entrySet()) {
					if (entry.getValue() == GatewayDirection.UNSPECIFIED || entry.getValue() == GatewayDirection.MIXED)
						keys.add(entry.getKey());
				}
				for (String key : keys)
					choices.remove(key);
    			return choices;
    		}
    	});
	}
	
}
