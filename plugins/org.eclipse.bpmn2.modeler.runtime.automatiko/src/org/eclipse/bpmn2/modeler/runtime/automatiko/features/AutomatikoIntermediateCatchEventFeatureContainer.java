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
package org.eclipse.bpmn2.modeler.runtime.automatiko.features;

import org.eclipse.bpmn2.modeler.ui.features.event.IntermediateCatchEventFeatureContainer;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class AutomatikoIntermediateCatchEventFeatureContainer extends IntermediateCatchEventFeatureContainer {

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddIntermediateCatchEventFeature(fp){

			@Override
			public PictogramElement add(IAddContext context) {
				PictogramElement pe = super.add(context);
				return pe;
			}
			
		};
	}
}
