package org.eclipse.bpmn2.modeler.core.runtime;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.bpmn2.modeler.core.runtime.messages"; //$NON-NLS-1$
	public static String ModelExtensionDescriptor_Create;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}