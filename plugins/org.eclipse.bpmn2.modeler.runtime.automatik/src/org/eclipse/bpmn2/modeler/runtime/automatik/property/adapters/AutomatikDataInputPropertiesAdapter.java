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
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.modeler.runtime.automatik.util.AutomatikModelUtil;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.DataInputPropertiesAdapter;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.ItemDefinitionRefFeatureDescriptor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AutomatikDataInputPropertiesAdapter extends DataInputPropertiesAdapter {

	public AutomatikDataInputPropertiesAdapter(AdapterFactory adapterFactory, DataInput object) {
		super(adapterFactory, object);

    	EStructuralFeature feature = Bpmn2Package.eINSTANCE.getItemAwareElement_ItemSubjectRef();
    	setProperty(feature, UI_CAN_CREATE_NEW, Boolean.TRUE);
    	setProperty(feature, UI_CAN_EDIT, Boolean.TRUE);
		setProperty(feature, UI_IS_MULTI_CHOICE, Boolean.TRUE);
		
    	setFeatureDescriptor(feature,
			new ItemDefinitionRefFeatureDescriptor<DataInput>(this,object,feature) {
				
	    		@Override
	    		protected void internalSet(DataInput dataInput, EStructuralFeature feature, Object value, int index) {
	    			value = AutomatikModelUtil.getDataType(dataInput, value);
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
					return AutomatikModelUtil.getChoiceOfValues(object);
				}
				
				@Override
				public boolean isMultiLine() {
					return true;
				}
			}
    	);
	}

}
