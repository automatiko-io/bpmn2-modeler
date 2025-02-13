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
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class AutomatikoAdHocSubProcessPropertySection extends AutomatikoActivityPropertySection {

	@Override
	protected AbstractDetailComposite createSectionRoot() {
		return new AutomatikoAdHocSubProcessDetailComposite(this);
	}

	@Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
		return new AutomatikoAdHocSubProcessDetailComposite(parent,style);
	}

	@Override
	public boolean appliesTo(EObject eObj) {
		return eObj.eClass() == Bpmn2Package.eINSTANCE.getAdHocSubProcess();
	}
}
