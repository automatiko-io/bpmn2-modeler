/**
 */
package org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.util;

import org.eclipse.bpmn2.util.OnlyContainmentTypeInfo;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.ElementHandlerImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.util.ExtensionResourceImpl
 * @generated
 */
public class ExtensionResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExtensionResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Resource createResource(URI uri) {
    	ExtensionResourceImpl result = new ExtensionResourceImpl(uri);

        result.getDefaultSaveOptions().put(XMLResource.OPTION_SAVE_TYPE_INFORMATION,
   
                new OnlyContainmentTypeInfo() {

					@Override
					public boolean shouldSaveType(EClass objectType,
							EClassifier featureType, EStructuralFeature feature) {
						if ("AnyType".equals(objectType.getName()))
							return false;
						return super.shouldSaveType(objectType, featureType, feature);
					}

					@Override
					public boolean shouldSaveType(EClass objectType,
							EClass featureType, EStructuralFeature feature) {
						if ("AnyType".equals(objectType.getName()))
							return false;
						return super.shouldSaveType(objectType, featureType, feature);
					}
        	
        });

        // allow "href" object resolution
        result.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE,
                Boolean.FALSE);

        result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);

        result.getDefaultSaveOptions().put(XMLResource.OPTION_ELEMENT_HANDLER,
                new ElementHandlerImpl(true));

        result.getDefaultSaveOptions().put(XMLResource.OPTION_ENCODING, "UTF-8");
        
        // save xsi:schemaLocation in Definitions parameter
        result.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

        return result;
	}

} //DroolsResourceFactoryImpl
