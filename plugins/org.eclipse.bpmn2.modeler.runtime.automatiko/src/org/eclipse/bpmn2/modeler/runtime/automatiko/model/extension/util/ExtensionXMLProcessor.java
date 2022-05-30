/**
 */
package org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.util;

import java.util.Map;

import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtensionXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ExtensionPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the DroolsResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ExtensionResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ExtensionResourceFactoryImpl());
		}
		return registrations;
	}

} //DroolsXMLProcessor
