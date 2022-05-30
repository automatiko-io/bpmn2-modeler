/*******************************************************************************
 * Copyright (c) 2011, 2012, 2013, 2014 Red Hat, Inc.
 * All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.bpmn2.modeler.runtime.automatiko.util;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.bpmn2.modeler.runtime.automatiko.util.messages"; //$NON-NLS-1$
	public static String AutomatikoImportDialog_Create_Process_Variables_Label;
	public static String AutomatikoInterfaceImportDialog_Available_Methods;
	public static String AutomatikoInterfaceImportDialog_Select_All;
	public static String AutomatikoInterfaceImportDialog_Select_None;
	public static String AutomatikoModelUtil_Duplicate_Import_Message;
	public static String AutomatikoModelUtil_Duplicate_Import_Title;
	public static String AutomatikoModelUtil_No_Process_Message;
	public static String AutomatikoModelUtil_No_Process_Title;
	public static String AutomatikoModelUtil_Scenario_Name;
	public static String AutomatikoModelUtil_Simulation;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
