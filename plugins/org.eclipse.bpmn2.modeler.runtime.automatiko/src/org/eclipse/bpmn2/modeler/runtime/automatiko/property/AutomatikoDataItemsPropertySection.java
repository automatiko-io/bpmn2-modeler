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

import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.ComboObjectEditor;
import org.eclipse.bpmn2.modeler.core.merrimac.dialogs.ObjectEditor;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatiko.util.AutomatikoModelUtil;
import org.eclipse.bpmn2.modeler.ui.property.diagrams.DataItemsPropertySection;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IType;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class AutomatikoDataItemsPropertySection extends DataItemsPropertySection {

	@Override
	protected AbstractDetailComposite createSectionRoot() {
		return new AutomatikoDataItemsDetailComposite(this);
	}

	@Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
		return new AutomatikoDataItemsDetailComposite(parent,style);
	}

	public class GlobalTypeDetailComposite extends DefaultDetailComposite {

		public GlobalTypeDetailComposite(Composite parent, int style) {
			super(parent, style);
		}

		public GlobalTypeDetailComposite(AbstractBpmn2PropertySection section) {
			super(section);
		}
		
		@Override
		protected void bindAttribute(Composite parent, EObject object, EAttribute attribute, String label) {
			if ("type".equals(attribute.getName())) { //$NON-NLS-1$
				ObjectEditor editor = new ComboObjectEditor(this,object,attribute) {
					
					@Override
					protected boolean canCreateNew() {
						return true;
					}
					
					protected EObject createObject() throws Exception {
						IType type = (IType) AutomatikoModelUtil.showImportDialog(object);
						if (type!=null) {
							ImportType it = AutomatikoModelUtil.addImport(type, object);
							if (it==null)
								throw new OperationCanceledException(Messages.AutomatikoDataItemsPropertySection_Duplicate_Import);
							return it;
						}
						throw new OperationCanceledException(Messages.AutomatikoDataItemsPropertySection_Dialog_Cancelled);
					}
				};
				editor.createControl(parent,label);
			}
			else
				super.bindAttribute(parent, object, attribute, label);
		}
		
	}
}
