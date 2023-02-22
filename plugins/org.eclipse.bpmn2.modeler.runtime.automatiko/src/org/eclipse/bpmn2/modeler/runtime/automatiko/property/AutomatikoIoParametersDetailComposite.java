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
package org.eclipse.bpmn2.modeler.runtime.automatiko.property;

import java.util.List;

import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.InputOutputSpecification;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ReceiveTask;
import org.eclipse.bpmn2.SendTask;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.modeler.core.adapters.InsertionAdapter;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.runtime.BaseRuntimeExtensionDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.CustomTaskDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.ModelExtensionDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.ModelExtensionDescriptor.Property;
import org.eclipse.bpmn2.modeler.core.runtime.TargetRuntime;
import org.eclipse.bpmn2.modeler.ui.property.tasks.IoParametersDetailComposite;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;

public class AutomatikoIoParametersDetailComposite extends IoParametersDetailComposite {

	public AutomatikoIoParametersDetailComposite(Composite parent, int style) {
		super(parent, style);
	}

	public AutomatikoIoParametersDetailComposite(AbstractBpmn2PropertySection section) {
		super(section);
	}

	@Override
	public void createBindings(final EObject be) {
		final EStructuralFeature ioSpecificationFeature = be.eClass().getEStructuralFeature("ioSpecification"); //$NON-NLS-1$
		if (ioSpecificationFeature != null) {
			// the control parameter must be an Activity or CallableElement (i.e. a Process or GlobalTask)
			InputOutputSpecification ioSpecification = (InputOutputSpecification)be.eGet(ioSpecificationFeature);
			if (ioSpecification==null) {
				ioSpecification = createModelObject(InputOutputSpecification.class);
				InsertionAdapter.add(be, ioSpecificationFeature, ioSpecification);
			}
			
			if (!(be instanceof ReceiveTask)) {
				EStructuralFeature dataInputsFeature = getFeature(ioSpecification, "dataInputs"); //$NON-NLS-1$
				if (isModelObjectEnabled(ioSpecification.eClass(),dataInputsFeature)) {
					dataInputsTable = new AutomatikoIoParametersListComposite(this, be, ioSpecification, dataInputsFeature);
					dataInputsTable.bindList(ioSpecification, dataInputsFeature);
					dataInputsTable.setTitle(Messages.AutomatikoIoParametersDetailComposite_Input_Mapping_Title);
				}
			}
			
			if (!(be instanceof SendTask)) {
				EStructuralFeature dataOutputsFeature = getFeature(ioSpecification, "dataOutputs"); //$NON-NLS-1$
				if (isModelObjectEnabled(ioSpecification.eClass(),dataOutputsFeature)) {
					dataOutputsTable = new AutomatikoIoParametersListComposite(this, be, ioSpecification, dataOutputsFeature);
					dataOutputsTable.bindList(ioSpecification, dataOutputsFeature);
					dataOutputsTable.setTitle(Messages.AutomatikoIoParametersDetailComposite_Output_Mapping_Title);
				}
			}
		}
	}
	
	public static boolean isCustomTask(EObject object) {
		CustomTaskDescriptor ctd = BaseRuntimeExtensionDescriptor.getDescriptor(object, CustomTaskDescriptor.class);
		if (ctd!=null) {
			return true;
		}
		return false;
	}
	
	public static boolean isCustomTaskIOParameter(ItemAwareElement input) {
		String name = null;
		if (input instanceof DataInput)
			name = ((DataInput)input).getName();
		else if (input instanceof DataOutput)
			name = ((DataOutput)input).getName();
		else
			return false;
		return isCustomTaskIOParameter(input, name);
	}
	
	
	public static boolean isCustomTaskIOParameter(ItemAwareElement input, String name) {

		Activity activity = findActivity(input);
		if (activity==null || name==null || name.isEmpty())
			return false;
		
		TargetRuntime rt = TargetRuntime.getRuntime(activity);
		
		List<Property> props = null;
		CustomTaskDescriptor ctd = BaseRuntimeExtensionDescriptor.getDescriptor(activity, CustomTaskDescriptor.class);
		if (ctd!=null) {
			props = ctd.getProperties("ioSpecification/dataInputs/name"); //$NON-NLS-1$
			if (props!=null) {
				for (Property p : props) {
					Object propName = p.getFirstStringValue();
					if (propName!=null && name.equals(propName)) {
						return true;
					}
				}
			}
		}
		ModelExtensionDescriptor med = rt.getModelExtensionDescriptor(activity, false);
		if (med!=null) {
			props = med.getProperties("ioSpecification/dataInputs/name"); //$NON-NLS-1$
			if (props!=null) {
				for (Property p : props) {
					Object propName = p.getFirstStringValue();
					if (propName!=null && name.equals(propName)) {
						return true;
					}
				}
			}
		}
		
		if (activity instanceof SendTask) {
			if ("Message".equals(name)) {
				return true;
			}
		}
		else if (activity instanceof ReceiveTask) {
			if ("Message".equals(name)) {
				return true;
			}
		}
		return false;
	}
		
	public static Activity findActivity(EObject be) {
		while (be!=null && !(be instanceof Activity)) {
			be = be.eContainer();
		}
		return (Activity)be;
	}

}
