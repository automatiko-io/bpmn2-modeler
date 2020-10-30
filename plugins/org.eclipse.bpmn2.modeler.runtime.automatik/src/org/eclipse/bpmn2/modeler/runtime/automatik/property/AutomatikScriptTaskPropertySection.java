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

package org.eclipse.bpmn2.modeler.runtime.automatik.property;

import org.eclipse.bpmn2.ScriptTask;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class AutomatikScriptTaskPropertySection extends AutomatikTaskPropertySection {

	@Override
	protected AbstractDetailComposite createSectionRoot() {
		return new AutomatikScriptTaskDetailComposite(this);
	}

	@Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
		return new AutomatikScriptTaskDetailComposite(parent,style);
	}
	
	@Override
	public boolean appliesTo(EObject eObj) {
		return eObj instanceof ScriptTask;
	}
}
