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
package org.eclipse.bpmn2.modeler.runtime.automatiko.property;


import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.ui.property.data.InterfacePropertySection;
import org.eclipse.swt.widgets.Composite;

public class AutomatikoInterfacePropertySection extends InterfacePropertySection {

	@Override
	protected AbstractDetailComposite createSectionRoot() {
		return new AutomatikoInterfaceDetailComposite(this);
	}

	@Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
		return new AutomatikoInterfaceDetailComposite(parent, style);
	}
}
