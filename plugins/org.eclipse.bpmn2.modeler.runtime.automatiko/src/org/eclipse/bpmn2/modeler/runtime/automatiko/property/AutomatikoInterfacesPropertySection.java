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

import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Interface;
import org.eclipse.bpmn2.modeler.core.Activator;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoInterfaceImportDialog;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoModelUtil;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoModelUtil.ImportHandler;
import org.eclipse.bpmn2.modeler.ui.property.data.InterfacesPropertySection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class AutomatikoInterfacesPropertySection extends InterfacesPropertySection {

    public AutomatikoInterfacesPropertySection() {
        super();
    }

    @Override
    protected AbstractDetailComposite createSectionRoot() {
        return new AutomatikoInterfacesSectionRoot(this);
    }

    @Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
        return new AutomatikoInterfacesSectionRoot(parent,style);
	}

	public class AutomatikoInterfacesSectionRoot extends InterfacesSectionRoot {

        public AutomatikoInterfacesSectionRoot(Composite parent, int style) {
            super(parent, style);
        }

        public AutomatikoInterfacesSectionRoot(AbstractBpmn2PropertySection section) {
            super(section);
        }

        @Override
        public void createBindings(EObject be) {
            definedInterfacesTable = new AutomatikoDefinedInterfaceListComposite(this);
            definedInterfacesTable.bindList(be);
        }

    }

    private class AutomatikoDefinedInterfaceListComposite extends DefinedInterfaceListComposite {

        public AutomatikoDefinedInterfaceListComposite(Composite parent) {
            super(parent);
        }

        @Override
        public void bindList(EObject theobject) {
        	// TODO: push this up to super
        	// this also requires that the AutomatikoImportDialog is moved to the core plugin
        	// also AutomatikoModelUtil.ImportHandler
            super.bindList(theobject);
            ImageDescriptor id = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/20/import.png"); //$NON-NLS-1$
            Action importAction = new Action(Messages.AutomatikoInterfacePropertySection_Import_Action, id) {
                @Override
                public void run() {
                    super.run();
                    editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
                        @Override
                        protected void doExecute() {
                            EObject newItem = importListItem(businessObject, feature);
                            if (newItem != null) {
                                final EList<EObject> list = (EList<EObject>) businessObject.eGet(feature);
                                tableViewer.setInput(list);
                                tableViewer.setSelection(new StructuredSelection(newItem));
                                //showDetails(true);
                            }
                        }
                    });
                }
            };
            tableToolBarManager.insert(1, new ActionContributionItem(importAction));
            tableToolBarManager.update(true);
        }

        protected EObject importListItem(EObject object, EStructuralFeature feature) {
        	final AutomatikoInterfaceImportDialog dialog = new AutomatikoInterfaceImportDialog();
        	dialog.open();
            final IType selectedType = dialog.getIType();
            final Definitions definitions = ModelUtil.getDefinitions(object);
            if (selectedType == null || definitions==null) {
                return null;
            }
            
            // add this IType to the list of <import> extension elements
    		AutomatikoModelUtil.addImport(selectedType, object, false, dialog.isCreateVariables());

    		ImportHandler importer = new ImportHandler();
    		importer.setCreateVariables( dialog.isCreateVariables() );
    		
    		final Interface iface = importer.createInterface(definitions, null, selectedType, dialog.getIMethods());
            EList<EObject> list = (EList<EObject>) object.eGet(feature);
            list.add(iface);
            return iface;
        }
    }
}
