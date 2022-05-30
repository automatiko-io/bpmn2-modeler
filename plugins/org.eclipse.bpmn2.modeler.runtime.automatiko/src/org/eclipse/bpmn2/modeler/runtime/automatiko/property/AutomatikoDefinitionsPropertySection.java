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

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractPropertiesProvider;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultListComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.ListCompositeColumnProvider;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.TableColumn;
import org.eclipse.bpmn2.modeler.ui.property.diagrams.DefinitionsPropertySection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class AutomatikoDefinitionsPropertySection extends DefinitionsPropertySection {

	@Override
	protected AbstractDetailComposite createSectionRoot() {
		return new AutomatikoDefinitionsPropertyComposite(this);
	}

	@Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
		return new AutomatikoDefinitionsPropertyComposite(parent,style);
	}
	
	public class AutomatikoMessageDetailComposite extends DefaultDetailComposite {

		private AbstractPropertiesProvider propertiesProvider;

		public AutomatikoMessageDetailComposite(Composite parent, int style) {
			super(parent, style);
		}

		/**
		 * @param section
		 */
		public AutomatikoMessageDetailComposite(AbstractBpmn2PropertySection section) {
			super(section);
		}

		@Override
		public AbstractPropertiesProvider getPropertiesProvider(EObject object) {
			if (propertiesProvider==null) {
				propertiesProvider = new AbstractPropertiesProvider(object) {
					String[] properties = new String[] {
							"id", //$NON-NLS-1$
							"name", //$NON-NLS-1$
							"itemRef" //$NON-NLS-1$
					};
					
					@Override
					public String[] getProperties() {
						return properties; 
					}
				};
			}
			return propertiesProvider;
		}
		
		@Override
		protected boolean isModelObjectEnabled(String className, String featureName) {
			return true;
		}
	}
	
	public class AutomatikoMessageListComposite extends DefaultListComposite {

		public AutomatikoMessageListComposite(AbstractBpmn2PropertySection section, int style) {
			super(section, style);
			// TODO Auto-generated constructor stub
		}

		public AutomatikoMessageListComposite(AbstractBpmn2PropertySection section) {
			super(section, DEFAULT_STYLE);
		}

		public AutomatikoMessageListComposite(Composite parent, int style) {
			super(parent, DEFAULT_STYLE);
		}
		
		@Override
		public ListCompositeColumnProvider getColumnProvider(EObject object, EStructuralFeature feature) {
			if (columnProvider==null) {
				columnProvider = new ListCompositeColumnProvider(this);
				TableColumn tc = new TableColumn(object,Bpmn2Package.eINSTANCE.getBaseElement_Id());
				tc.setHeaderText(Messages.AutomatikoDefinitionsPropertySection_Name); 
				columnProvider.add(tc);
				columnProvider.add(new TableColumn(object,Bpmn2Package.eINSTANCE.getMessage_ItemRef()));
			}
			return columnProvider;
		}

		@Override
		protected boolean isModelObjectEnabled(String className, String featureName) {
			return true;
		}
	}

}
