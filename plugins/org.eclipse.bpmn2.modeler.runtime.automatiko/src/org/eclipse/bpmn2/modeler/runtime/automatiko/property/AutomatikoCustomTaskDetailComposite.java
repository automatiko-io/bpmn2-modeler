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
import org.eclipse.swt.widgets.Composite;

public class AutomatikoCustomTaskDetailComposite extends AutomatikoTaskDetailComposite {

	public AutomatikoCustomTaskDetailComposite(Composite parent, int style) {
		super(parent, style);
	}

	public AutomatikoCustomTaskDetailComposite(AbstractBpmn2PropertySection section) {
		super(section);
	}

	@Override
	protected boolean isModelObjectEnabled(String className, String featureName) {
		return !"anyAttribute".equals(featureName); //$NON-NLS-1$
	}
}
