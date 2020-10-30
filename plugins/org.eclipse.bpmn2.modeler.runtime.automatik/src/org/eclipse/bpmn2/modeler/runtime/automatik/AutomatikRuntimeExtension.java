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
import org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikActivityDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikCommonEventDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikDataAssociationDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikDefinitionsPropertySection.AutomatikMessageDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikDefinitionsPropertySection.AutomatikMessageListComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikExpressionDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikGatewayDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikmportTypeDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikInterfaceDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikItemDefinitionDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikItemDefinitionListComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikManualTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikMultiInstanceDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikOperationDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikReceiveTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikScriptTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikSendTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikSequenceFlowDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatik.property.AutomatikTaskDetailComposite;
import org.eclipse.bpmn2.modeler.ui.AbstractBpmn2RuntimeExtension.RootElementParser;
import org.eclipse.bpmn2.modeler.ui.wizards.FileService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.IEditorInput;
import org.xml.sax.InputSource;

public class AutomatikRuntimeExtension implements IBpmn2RuntimeExtension {
	
	public final static String JBPM5_RUNTIME_ID = "bpmn2.automatik"; //$NON-NLS-1$
	public final static String AUTOMATIK_NAMESPACE = "https://automatik-platform.io"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * Check if the given input file is a automatik-generated (jBPM) process file.
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
			PropertiesCompositeFactory.register(Activity.class, AutomatikActivityDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(DataInput.class, AutomatikDataAssociationDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(DataOutput.class, AutomatikDataAssociationDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Event.class, AutomatikCommonEventDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Gateway.class, AutomatikGatewayDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ImportType.class, AutomatikmportTypeDetailComposite.class, targetRuntime);	        
	        PropertiesCompositeFactory.register(ItemDefinition.class, AutomatikItemDefinitionListComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ManualTask.class, AutomatikManualTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Message.class, AutomatikMessageDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Message.class, AutomatikMessageListComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(MultiInstanceLoopCharacteristics.class, AutomatikMultiInstanceDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ReceiveTask.class, AutomatikReceiveTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ScriptTask.class, AutomatikScriptTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(SendTask.class, AutomatikSendTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(SequenceFlow.class, AutomatikSequenceFlowDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Task.class, AutomatikTaskDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(ItemDefinition.class, AutomatikItemDefinitionDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Interface.class, AutomatikInterfaceDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Operation.class, AutomatikOperationDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Expression.class, AutomatikExpressionDetailComposite.class, targetRuntime);
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
