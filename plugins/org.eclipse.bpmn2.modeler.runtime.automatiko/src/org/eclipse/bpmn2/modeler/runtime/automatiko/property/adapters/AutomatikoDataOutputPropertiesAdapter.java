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
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoModelUtil;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.DataOutputPropertiesAdapter;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.ItemDefinitionRefFeatureDescriptor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AutomatikoDataOutputPropertiesAdapter extends DataOutputPropertiesAdapter {

	public AutomatikoDataOutputPropertiesAdapter(AdapterFactory adapterFactory, DataOutput object) {
		super(adapterFactory, object);

    	EStructuralFeature feature = Bpmn2Package.eINSTANCE.getItemAwareElement_ItemSubjectRef();
    	setProperty(feature, UI_CAN_CREATE_NEW, Boolean.TRUE);
    	setProperty(feature, UI_CAN_EDIT, Boolean.TRUE);
		setProperty(feature, UI_IS_MULTI_CHOICE, Boolean.TRUE);
		
    	setFeatureDescriptor(feature,
			new ItemDefinitionRefFeatureDescriptor<DataOutput>(this,object,feature) {
				
	    		@Override
	    		protected void internalSet(DataOutput dataOutput, EStructuralFeature feature, Object value, int index) {
	    			value = AutomatikoModelUtil.getDataType(dataOutput, value);
	    			super.internalSet(object, feature, value, index);
				}
	    		
	    		@Override
				protected void changeReferences(RootElement object, ItemDefinition itemDefinition) {
	    			// do nothing!
	    		}
	    		
	    		@Override
				protected void changeReferences(ItemAwareElement object, ItemDefinition itemDefinition) {
	    			// do nothing!
	    		}

				@Override
				public Hashtable<String, Object> getChoiceOfValues() {
					return AutomatikoModelUtil.getChoiceOfValues(object);
				}
				
				@Override
				public boolean isMultiLine() {
					return true;
				}
			}
    	);
	}

}
