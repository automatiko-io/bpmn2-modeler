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

import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.ui.property.diagrams.ItemDefinitionListComposite;
import org.eclipse.swt.widgets.Composite;

public class AutomatikoItemDefinitionListComposite extends
		ItemDefinitionListComposite {

	public AutomatikoItemDefinitionListComposite(AbstractBpmn2PropertySection section, int style) {
		super(section, DEFAULT_STYLE);
	}

	public AutomatikoItemDefinitionListComposite(AbstractBpmn2PropertySection section) {
		super(section, DEFAULT_STYLE);
	}

	public AutomatikoItemDefinitionListComposite(Composite parent, int style) {
		super(parent, DEFAULT_STYLE);
	}

	public AutomatikoItemDefinitionListComposite(Composite parent) {
		super(parent, DEFAULT_STYLE);
	}

}
