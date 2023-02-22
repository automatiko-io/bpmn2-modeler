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

package org.eclipse.bpmn2.modeler.runtime.automatiko.property;

import org.eclipse.bpmn2.CallableElement;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesProvider;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.BooleanObjectEditor;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.ObjectEditor;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.TextAndButtonObjectEditor;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionFactory;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExternalProcess;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoModelUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class AutomatikoCallActivityDetailComposite extends AutomatikoActivityDetailComposite {

	BooleanObjectEditor independentEditor;
	Button independentCheckbox;
	Button waitForCompletionCheckbox;
	
	public AutomatikoCallActivityDetailComposite(AbstractBpmn2PropertySection section) {
		super(section);
	}

	public AutomatikoCallActivityDetailComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void bindAttribute(Composite parent, EObject object, EAttribute attribute, String label) {

		if ("independent".equals(attribute.getName())) {
			independentEditor = new BooleanObjectEditor(this,object,attribute);
			independentCheckbox = (Button) independentEditor.createControl(parent,label);
			if (waitForCompletionCheckbox!=null && waitForCompletionCheckbox.getSelection()==false) {
				independentCheckbox.setEnabled(false);
			}
		}
		else if ("waitForCompletion".equals(attribute.getName())) {
			ObjectEditor editor = new BooleanObjectEditor(this,object,attribute);
			waitForCompletionCheckbox = (Button) editor.createControl(parent,label);
			waitForCompletionCheckbox.addSelectionListener( new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					boolean checked = waitForCompletionCheckbox.getSelection();
					if (!checked) {
						independentCheckbox.setEnabled(false);
						independentEditor.setValue(Boolean.TRUE);
					}
					else {
						independentCheckbox.setEnabled(true);
					}
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			if (waitForCompletionCheckbox.getSelection()==false) {
				if (independentCheckbox!=null)
					independentCheckbox.setEnabled(false);
			}
		}
		else
			super.bindAttribute(parent, object, attribute, label);
	}
	
	@Override
	protected void bindReference(Composite parent, EObject object, EReference reference) {
		if ("calledElementRef".equals(reference.getName())) { //$NON-NLS-1$
			if (isModelObjectEnabled(object.eClass(), reference)) {
				if (parent==null)
					parent = getAttributesParent();
				
				String displayName = ExtendedPropertiesProvider.getLabel(object, reference);
				ObjectEditor editor = new TextAndButtonObjectEditor(this,object,reference) {

					@Override
					protected void buttonClicked(int buttonId) {
						final IInputValidator validator = new IInputValidator() {

							@Override
							public String isValid(String newText) {
								if (newText==null ||newText.isEmpty())
									return Messages.AutomatikoCallActivityDetailComposite_Error_Empty;
								if (!AutomatikoModelUtil.isProcessId(newText))
									return Messages.AutomatikoCallActivityDetailComposite_Error_Invalid;
								return null;
							}
							
						};
						
						String initialValue = ExtendedPropertiesProvider.getTextValue(object,feature);
						InputDialog dialog = new InputDialog(
								getShell(),
								Messages.AutomatikoCallActivityDetailComposite_Title,
								Messages.AutomatikoCallActivityDetailComposite_Message,
								initialValue,
								validator);
						if (dialog.open()==Window.OK){
							setValue(dialog.getValue());
						}
					}
					
					
					@Override
					public boolean setValue(final Object result) {
						if (result != object.eGet(feature)) {
							TransactionalEditingDomain domain = getDiagramEditor().getEditingDomain();
							domain.getCommandStack().execute(new RecordingCommand(domain) {
								@Override
								protected void doExecute() {
									String id = result.toString();
									CallableElement ce = null;
									Definitions defs = ModelUtil.getDefinitions(object);
									for (RootElement re : defs.getRootElements()) {
										if (re instanceof ExternalProcess) {
											if (id.equals(re.getId())) {
												ce = (ExternalProcess) re;
												break;
											}
										}
									}
									if (ce==null) {
										ce = ExtensionFactory.eINSTANCE.createExternalProcess();
										ce.setName(id);
										ce.setId(id);
										defs.getRootElements().add(ce);
									}
									
									object.eSet(feature, ce);
								}
							});
//							if (getDiagramEditor().getDiagnostics()!=null) {
//								ErrorUtils.showErrorMessage(getDiagramEditor().getDiagnostics().getMessage());
//							}
//							else {
//								ErrorUtils.showErrorMessage(null);
//								updateText();
//								return true;
//							}
							updateText();
							return true;
						}
						return false;
					}
				};
				editor.createControl(parent,displayName);
			}
		}
		else
			super.bindReference(parent, object, reference);
	}
}
