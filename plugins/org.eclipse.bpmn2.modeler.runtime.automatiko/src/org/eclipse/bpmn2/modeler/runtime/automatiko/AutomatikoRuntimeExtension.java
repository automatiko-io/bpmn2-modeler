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
package org.eclipse.bpmn2.modeler.runtime.automatiko;

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
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoActivityDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoCommonEventDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoDataAssociationDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoExpressionDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoGatewayDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoInterfaceDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoItemDefinitionDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoItemDefinitionListComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoManualTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoMultiInstanceDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoOperationDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoReceiveTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoScriptTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoSendTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoSequenceFlowDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoTaskDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikomportTypeDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoDefinitionsPropertySection.AutomatikoMessageDetailComposite;
import org.eclipse.bpmn2.modeler.runtime.automatiko.property.AutomatikoDefinitionsPropertySection.AutomatikoMessageListComposite;
import org.eclipse.bpmn2.modeler.ui.AbstractBpmn2RuntimeExtension.RootElementParser;
import org.eclipse.bpmn2.modeler.ui.wizards.FileService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.IEditorInput;
import org.xml.sax.InputSource;

public class AutomatikoRuntimeExtension implements IBpmn2RuntimeExtension {
	
	public final static String AUTOMATIKO_RUNTIME_ID = "bpmn2.automatiko"; //$NON-NLS-1$
	public final static String AUTOMATIKO_NAMESPACE = "https://automatiko.io"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * Check if the given input file is a automatik-generated (jBPM) process file.
	 * 
	 * @see org.eclipse.bpmn2.modeler.core.IBpmn2RuntimeExtension#isContentForRuntime(org.eclipse.core.resources.IFile)
	 */
	@Override
	public boolean isContentForRuntime(IEditorInput input) {
		InputSource source = new InputSource( FileService.getInputContents(input) );
		RootElementParser parser = new RootElementParser(AUTOMATIKO_NAMESPACE);
		parser.parse(source);
		return parser.getResult();
	}

	@Override
	public String getTargetNamespace(Bpmn2DiagramType diagramType){
		return AUTOMATIKO_NAMESPACE;
	}

	
	@Override
	public void notify(LifecycleEvent event) {
        TargetRuntime targetRuntime = event.targetRuntime;

		if (event.eventType == EventType.EDITOR_INITIALIZED) {
			// Register all of our Property Tab Detail overrides here. 
			PropertiesCompositeFactory.register(Activity.class, AutomatikoActivityDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(DataInput.class, AutomatikoDataAssociationDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(DataOutput.class, AutomatikoDataAssociationDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Event.class, AutomatikoCommonEventDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Gateway.class, AutomatikoGatewayDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ImportType.class, AutomatikomportTypeDetailComposite.class, targetRuntime);	        
	        PropertiesCompositeFactory.register(ItemDefinition.class, AutomatikoItemDefinitionListComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ManualTask.class, AutomatikoManualTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Message.class, AutomatikoMessageDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Message.class, AutomatikoMessageListComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(MultiInstanceLoopCharacteristics.class, AutomatikoMultiInstanceDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ReceiveTask.class, AutomatikoReceiveTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(ScriptTask.class, AutomatikoScriptTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(SendTask.class, AutomatikoSendTaskDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(SequenceFlow.class, AutomatikoSequenceFlowDetailComposite.class, targetRuntime);
	        PropertiesCompositeFactory.register(Task.class, AutomatikoTaskDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(ItemDefinition.class, AutomatikoItemDefinitionDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Interface.class, AutomatikoInterfaceDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Operation.class, AutomatikoOperationDetailComposite.class, targetRuntime);
			PropertiesCompositeFactory.register(Expression.class, AutomatikoExpressionDetailComposite.class, targetRuntime);
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
