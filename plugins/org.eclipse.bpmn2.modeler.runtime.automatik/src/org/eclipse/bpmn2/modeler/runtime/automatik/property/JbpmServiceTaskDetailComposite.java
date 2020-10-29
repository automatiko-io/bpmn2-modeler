/*******************************************************************************
 * Copyright (c) 2011, 2012 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/

package org.eclipse.bpmn2.modeler.runtime.automatik.property;


import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.Operation;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.ui.property.tasks.DataAssociationDetailComposite.MapType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class JbpmServiceTaskDetailComposite extends JbpmTaskDetailComposite {

	public JbpmServiceTaskDetailComposite(AbstractBpmn2PropertySection section) {
		super(section);
	}

	public JbpmServiceTaskDetailComposite(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	protected void createMessageAssociations(Composite container, Activity activity,
			EReference operationRef, Operation operation,
			EReference messageRef, Message message) {

		super.createMessageAssociations(container, activity,
				operationRef, operation,
				messageRef, message);
		
		outputComposite.setAllowedMapTypes(MapType.Property.getValue());
		inputComposite.setAllowedMapTypes(MapType.Property.getValue() | MapType.SingleAssignment.getValue());
	}
	
}
