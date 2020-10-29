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
package org.eclipse.bpmn2.modeler.runtime.automatik.features;

import org.eclipse.bpmn2.UserTask;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.UserTaskFeatureContainer;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class JbpmUserTaskFeatureContainer extends UserTaskFeatureContainer {

	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateUserTaskFeature(fp) {
			public UserTask createBusinessObject(ICreateContext context) {
				UserTask userTask = super.createBusinessObject(context);
				
				return userTask;
			}

		};
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddUserTaskFeature(fp) {

			@Override
			public PictogramElement add(IAddContext context) {
				PictogramElement pe = super.add(context);
				return pe;
			}
			
		};
	}

}
