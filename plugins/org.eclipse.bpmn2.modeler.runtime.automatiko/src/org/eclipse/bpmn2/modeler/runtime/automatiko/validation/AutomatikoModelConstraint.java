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
package org.eclipse.bpmn2.modeler.runtime.automatiko.validation;

import java.util.List;

import org.eclipse.bpmn2.BusinessRuleTask;
import org.eclipse.bpmn2.CallActivity;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Escalation;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.InputOutputSpecification;
import org.eclipse.bpmn2.Interface;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.Signal;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesAdapter;
import org.eclipse.bpmn2.modeler.core.runtime.ModelExtensionDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.ModelExtensionDescriptor.Property;
import org.eclipse.bpmn2.modeler.core.validation.validators.ItemAwareElementValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.BusinessRuleTaskValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.CallActivityValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.DataAssociationValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.DefinitionsValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.EscalationValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.GatewayValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.InterfaceValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.ProcessValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.SignalValidator;
import org.eclipse.bpmn2.modeler.runtime.automatiko.validation.validators.UserTaskValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

public class AutomatikoModelConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();
	
		if (object instanceof BusinessRuleTask) {
			return new BusinessRuleTaskValidator(ctx).validate((BusinessRuleTask) object);
		}
		if (object instanceof CallActivity) {
			return new CallActivityValidator(ctx).validate((CallActivity) object);
		}
		if (object instanceof UserTask) {
			return new UserTaskValidator(ctx).validate((UserTask)object);
		}	
		if (object instanceof Gateway) {
			return new GatewayValidator(ctx).validate((Gateway)object);
		}	
		if (object instanceof Process) {
			return new ProcessValidator(ctx).validate((Process)object);
		}	
		if (object instanceof Signal) {
			return new SignalValidator(ctx).validate((Signal)object);
		}	
		if (object instanceof Escalation) {
			return new EscalationValidator(ctx).validate((Escalation)object);
		}	
		if (object instanceof DataAssociation) {
			return new DataAssociationValidator(ctx).validate((DataAssociation)object);
		}	
		if (object instanceof Definitions) {
			return new DefinitionsValidator(ctx).validate((Definitions)object);
		}
		if (object instanceof Interface) {
			return new InterfaceValidator(ctx).validate((Interface)object);
		}
		if (object instanceof DataInput) {
			// don't validate DataInputs that are used for UserTask
			// Notifications or Reassignments as these don't require
			// a data type (ItemSubjectRef)
			DataInput input = (DataInput) object;
			if (input.eContainer() instanceof InputOutputSpecification) {
				InputOutputSpecification iospec = (InputOutputSpecification) input.eContainer();
				EObject container = iospec.eContainer();
			
				if (container instanceof Task) {
					// ...and apparently none of the "hard-coded" I/O parameters
					// for UserTask and ManualTask require a data type either
					ModelExtensionDescriptor med = null;
					ExtendedPropertiesAdapter<?> adapter = ExtendedPropertiesAdapter.adapt(container);
					if (adapter!=null) {
						// look for it in the property adapter first
						med = adapter.getProperty(ModelExtensionDescriptor.class);
					}
					
					if (med!=null) {
						// This Task object has additional properties defined either by way of the
						// <modelExtension> defined in the plugin.xml or in Work Item Definitions.
						List<Property> props = med.getProperties("ioSpecification/dataInputs/name"); //$NON-NLS-1$
						for (Property property : props) {
							final String name = property.getFirstStringValue();
							if (input.getName().equals(name)) {
								// this input parameter doesn't need validation
								return ctx.createSuccessStatus();
							}
						}
					}
				}
			}
			return new ItemAwareElementValidator(ctx).validate((DataInput)object);
		}
		return ctx.createSuccessStatus();
	}

}
