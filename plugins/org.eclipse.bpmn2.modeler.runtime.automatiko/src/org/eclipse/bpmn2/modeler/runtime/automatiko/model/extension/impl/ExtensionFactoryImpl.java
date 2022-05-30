/**
 */
package org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.impl;

import java.math.BigInteger;

import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionFactory;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExternalProcess;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.MetaDataType;
import org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.MetaValueType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtensionFactoryImpl extends EFactoryImpl implements ExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExtensionFactory init() {
		try {
			ExtensionFactory theDroolsFactory = new ExtensionFactoryImpl();
			if (theDroolsFactory != null) {
				return theDroolsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExtensionPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case ExtensionPackage.IMPORT_TYPE: return createImportType();
			case ExtensionPackage.META_DATA_TYPE: return createMetaDataType();
			case ExtensionPackage.META_VALUE_TYPE: return createMetaValueType();
			case ExtensionPackage.EXTERNAL_PROCESS: return createExternalProcess();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExtensionPackage.PACKAGE_NAME_TYPE:
				return createPackageNameTypeFromString(eDataType, initialValue);
			case ExtensionPackage.PRIORITY_TYPE:
				return createPriorityTypeFromString(eDataType, initialValue);
			case ExtensionPackage.TASK_NAME_TYPE:
				return createTaskNameTypeFromString(eDataType, initialValue);
			case ExtensionPackage.VERSION_TYPE:
				return createVersionTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExtensionPackage.PACKAGE_NAME_TYPE:
				return convertPackageNameTypeToString(eDataType, instanceValue);
			case ExtensionPackage.PRIORITY_TYPE:
				return convertPriorityTypeToString(eDataType, instanceValue);
			case ExtensionPackage.TASK_NAME_TYPE:
				return convertTaskNameTypeToString(eDataType, instanceValue);
			case ExtensionPackage.VERSION_TYPE:
				return convertVersionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportType createImportType() {
		ImportTypeImpl importType = new ImportTypeImpl();
		return importType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataType createMetaDataType() {
		MetaDataTypeImpl metaDataType = new MetaDataTypeImpl();
		return metaDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaValueType createMetaValueType() {
		MetaValueTypeImpl metaValueType = new MetaValueTypeImpl();
		return metaValueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalProcess createExternalProcess() {
		ExternalProcessImpl externalProcess = new ExternalProcessImpl();
		return externalProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPackageNameTypeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPackageNameTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger createPriorityTypeFromString(EDataType eDataType, String initialValue) {
		return (BigInteger)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.INTEGER, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.INTEGER, instanceValue);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTaskNameTypeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTaskNameTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createVersionTypeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVersionTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionPackage getDroolsPackage() {
		return (ExtensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExtensionPackage getPackage() {
		return ExtensionPackage.eINSTANCE;
	}

} //DroolsFactoryImpl
