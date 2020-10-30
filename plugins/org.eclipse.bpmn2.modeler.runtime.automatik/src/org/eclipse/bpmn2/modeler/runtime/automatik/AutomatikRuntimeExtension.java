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
package org.eclipse.bpmn2.modeler.runtime.automatik;

import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.Event;
import org.eclipse.bpmn2.Expression;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.Interface;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.ManualTask;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.MultiInstanceLoopCharacteristics;
import org.eclipse.bpmn2.Operation;
import org.eclipse.bpmn2.ReceiveTask;
import org.eclipse.bpmn2.ScriptTask;
import org.eclipse.bpmn2.SendTask;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.modeler.core.IBpmn2RuntimeExtension;
import org.eclipse.bpmn2.modeler.core.LifecycleEvent;
import org.eclipse.bpmn2.modeler.core.LifecycleEvent.EventType;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.PropertiesCompositeFactory;
import org.eclipse.bpmn2.modeler.core.runtime.TargetRuntime;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil.Bpmn2DiagramType;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmActivityDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmCommonEventDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmDataAssociationDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmDefinitionsPropertySection.JbpmMessageDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmDefinitionsPropertySection.JbpmMessageListComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmExpressionDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmGatewayDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmImportTypeDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmInterfaceDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmItemDefinitionDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmItemDefinitionListComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmManualTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmMultiInstanceDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmOperationDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmReceiveTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmScriptTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmSendTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmSequenceFlowDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.JbpmTaskDetailComposite;
import org.eclipse.bpmn2.modeler.ui.AbstractBpmn2RuntimeExtension.RootElementParser;
import org.eclipse.bpmn2.modeler.ui.wizards.FileService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.IEditorInput;
import org.xml.sax.InputSource;

public class AutomatikRuntimeExtension implements IBpmn2RuntimeExtension {
	
	public final static String JBPM5_RUNTIME_ID = "bpmn2.automatik"; //$NON-NLS-1$
	public final static String AUTOMATIK_NAMESPACE = "http://www.jboss.org/drools"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * Check if the given input file is a drools-generated (jBPM) process file.
	 * 
	 * @see org.eclipse.bpmn2.modeler.core.IBpmn2RuntimeExtension#isContentForRuntime(org.eclipse.core.resources.IFile)
	 */
	@Override
	public boolean isContentForRuntime(IEditorInput input) {
		InputSource source = new InputSource( FileService.getInputContents(input) );
		RootElementParser parser = new RootElementParser(AUTOMATIK_NAMESPACE);
		parser.parse(source);
		return parser.getResult();
	}

	@Override
	public String getTargetNamespace(Bpmn2DiagramType diagramType){
		return AUTOMATIK_NAMESPACE;
	}

	
	@Override
	public void notify(LifecycleEvent event) {
        TargetRuntime targetRuntime = event.targetRuntime;

		if (event.eventType == EventType.EDITOR_INITIALIZED) {
			// Register all of our Property Tab Detail overrides here. 
			PropertiesCompositeFactory.register(Activity.class, JbpmActivityDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(DataInput.class, JbpmDataAssociationDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(DataOutput.class, JbpmDataAssociationDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Event.class, JbpmCommonEventDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Gateway.class, JbpmGatewayDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ImportType.class, JbpmImportTypeDetailComposite.class, targetRuntime);	        
	        PropertiesCompositeFactory.register(ItemDefinition.class, JbpmItemDefinitionListComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ManualTask.class, JbpmManualTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Message.class, JbpmMessageDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Message.class, JbpmMessageListComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(MultiInstanceLoopCharacteristics.class, JbpmMultiInstanceDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ReceiveTask.class, JbpmReceiveTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ScriptTask.class, JbpmScriptTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(SendTask.class, JbpmSendTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(SequenceFlow.class, JbpmSequenceFlowDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Task.class, JbpmTaskDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(ItemDefinition.class, JbpmItemDefinitionDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Interface.class, JbpmInterfaceDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Operation.class, JbpmOperationDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Expression.class, JbpmExpressionDetailComposite.class, targetRuntime);
		}
		else if (event.eventType == EventType.BUSINESSOBJECT_CREATED) {
			EObject object = (EObject) event.target;
			// Add a name change adapter to every one of these objects.
			// See my rant in ProcessVariableNameChangeAdapter...
			if (ProcessVariableNameChangeAdapter.appliesTo(object)) {
				ProcessVariableNameChangeAdapter.adapt(object);
			}
			else if (MetaDataTypeAdapter.appliesTo(object)) {
				MetaDataTypeAdapter.adapt(object);
			}
		}
		else if (event.eventType == EventType.BUSINESSOBJECT_LOADED ||
				event.eventType == EventType.BUSINESSOBJECT_INITIALIZED) {
			EObject object = (EObject) event.target;
			if (ProcessVariableNameChangeAdapter.appliesTo(object)) {
				EStructuralFeature nameFeature = object.eClass().getEStructuralFeature("name"); //$NON-NLS-1$
				String n = (String) object.eGet(nameFeature);
				if (n==null || n.isEmpty()) {
					EStructuralFeature idFeature = object.eClass().getEStructuralFeature("id"); //$NON-NLS-1$
					object.eSet(nameFeature, object.eGet(idFeature));
				}
			}
			else if (ElementNameChangeAdapter.appliesTo(object)) {
				ElementNameChangeAdapter.adapt(object);
			}
		}
	}
}
