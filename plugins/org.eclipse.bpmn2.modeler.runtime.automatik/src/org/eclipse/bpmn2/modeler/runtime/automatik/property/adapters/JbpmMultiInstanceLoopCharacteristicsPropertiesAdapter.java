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

import org.eclipse.bpmn2.MultiInstanceLoopCharacteristics;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.JavaVariableNameObjectEditor;
import org.eclipse.bpmn2.modeler.ui.adapters.properties.MultiInstanceLoopCharacteristicsPropertiesAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;

public class JbpmMultiInstanceLoopCharacteristicsPropertiesAdapter extends MultiInstanceLoopCharacteristicsPropertiesAdapter {

	public JbpmMultiInstanceLoopCharacteristicsPropertiesAdapter(AdapterFactory adapterFactory, MultiInstanceLoopCharacteristics object) {
		super(adapterFactory, object);

		setProperty(INPUT_DATA_ITEM, UI_OBJECT_EDITOR_CLASS, JavaVariableNameObjectEditor.class);
		setProperty(OUTPUT_DATA_ITEM, UI_OBJECT_EDITOR_CLASS, JavaVariableNameObjectEditor.class);

		setFeatureDescriptor(LOOP_DATA_INPUT_REF, new LoopDataInputCollectionFeatureDescriptor(this, object) {
			@Override
			public Hashtable<String, Object> getChoiceOfValues() {
				Hashtable<String, Object> choices = super.getChoiceOfValues();
				return choices;
			}
		});
		
		setFeatureDescriptor(LOOP_DATA_OUTPUT_REF, new LoopDataOutputCollectionFeatureDescriptor(this, object) {
			@Override
			public Hashtable<String, Object> getChoiceOfValues() {
				Hashtable<String, Object> choices = super.getChoiceOfValues();
				return choices;
			}
		});
	}
}
