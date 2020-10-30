/**
 */
package org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.impl;

import java.math.BigInteger;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.di.BpmnDiPackage;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.DocumentRoot;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.DroolsFactory;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.DroolsPackage;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.ExternalProcess;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.MetaDataType;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.MetaValueType;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.util.DroolsValidator;
import org.eclipse.dd.dc.DcPackage;
import org.eclipse.dd.di.DiPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DroolsPackageImpl extends EPackageImpl implements DroolsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaValueTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType packageNameTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType priorityTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ruleFlowGroupTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType taskNameTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType versionTypeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.bpmn2.modeler.runtime.automatik.model.drools.DroolsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DroolsPackageImpl() {
		super(eNS_URI, DroolsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DroolsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DroolsPackage init() {
		if (isInited) return (DroolsPackage)EPackage.Registry.INSTANCE.getEPackage(DroolsPackage.eNS_URI);

		// Obtain or create and register package
		DroolsPackageImpl theDroolsPackage = new DroolsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		Bpmn2Package.eINSTANCE.eClass();
		BpmnDiPackage.eINSTANCE.eClass();
		DiPackage.eINSTANCE.eClass();
		DcPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDroolsPackage.createPackageContents();

		// Initialize created meta-data
		theDroolsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDroolsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return DroolsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDroolsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DroolsPackage.eNS_URI, theDroolsPackage);
		return theDroolsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ImportType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MetaData() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MetaValue() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_PackageName() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Priority() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_TaskName() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Version() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportType() {
		return importTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportType_Name() {
		return (EAttribute)importTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaDataType() {
		return metaDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaDataType_Name() {
		return (EAttribute)metaDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetaDataType_MetaValue() {
		return (EReference)metaDataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaValueType() {
		return metaValueTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaValueType_Mixed() {
		return (EAttribute)metaValueTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaValueType_Value() {
		return (EAttribute)metaValueTypeEClass.getEStructuralFeatures().get(1);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalProcess() {
		return externalProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPackageNameType() {
		return packageNameTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPriorityType() {
		return priorityTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTaskNameType() {
		return taskNameTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVersionType() {
		return versionTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DroolsFactory getDroolsFactory() {
		return (DroolsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IMPORT_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__META_DATA);
		createEReference(documentRootEClass, DOCUMENT_ROOT__META_VALUE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__PACKAGE_NAME);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__PRIORITY);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__TASK_NAME);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__VERSION);

		importTypeEClass = createEClass(IMPORT_TYPE);
		createEAttribute(importTypeEClass, IMPORT_TYPE__NAME);

		metaDataTypeEClass = createEClass(META_DATA_TYPE);
		createEAttribute(metaDataTypeEClass, META_DATA_TYPE__NAME);
		createEReference(metaDataTypeEClass, META_DATA_TYPE__META_VALUE);

		metaValueTypeEClass = createEClass(META_VALUE_TYPE);
		createEAttribute(metaValueTypeEClass, META_VALUE_TYPE__MIXED);
		createEAttribute(metaValueTypeEClass, META_VALUE_TYPE__VALUE);

		externalProcessEClass = createEClass(EXTERNAL_PROCESS);

		// Create data types
		packageNameTypeEDataType = createEDataType(PACKAGE_NAME_TYPE);
		priorityTypeEDataType = createEDataType(PRIORITY_TYPE);
		taskNameTypeEDataType = createEDataType(TASK_NAME_TYPE);
		versionTypeEDataType = createEDataType(VERSION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Bpmn2Package theBpmn2Package = (Bpmn2Package)EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI);
		//BpsimPackage theBpsimPackage = (BpsimPackage)EPackage.Registry.INSTANCE.getEPackage(BpsimPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		documentRootEClass.getESuperTypes().add(theBpmn2Package.getDocumentRoot());
		externalProcessEClass.getESuperTypes().add(theBpmn2Package.getCallableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocumentRoot_ImportType(), this.getImportType(), null, "importType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MetaData(), this.getMetaDataType(), null, "metaData", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MetaValue(), this.getMetaValueType(), null, "metaValue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_PackageName(), this.getPackageNameType(), "packageName", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Priority(), this.getPriorityType(), "priority", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_TaskName(), this.getTaskNameType(), "taskName", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Version(), this.getVersionType(), "version", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(importTypeEClass, ImportType.class, "ImportType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ImportType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaDataTypeEClass, MetaDataType.class, "MetaDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetaDataType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, MetaDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetaDataType_MetaValue(), this.getMetaValueType(), null, "metaValue", null, 1, 1, MetaDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaValueTypeEClass, MetaValueType.class, "MetaValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetaValueType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, MetaValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaValueType_Value(), ecorePackage.getEString(), "value", null, 1, 1, MetaValueType.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(externalProcessEClass, ExternalProcess.class, "ExternalProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(packageNameTypeEDataType, String.class, "PackageNameType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(priorityTypeEDataType, BigInteger.class, "PriorityType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(taskNameTypeEDataType, String.class, "TaskNameType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(versionTypeEDataType, String.class, "VersionType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_ImportType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "import",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_MetaData(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "metaData",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_MetaValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "metaValue",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_PackageName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "packageName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Priority(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "priority",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_TaskName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "taskName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "version",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (importTypeEClass, 
		   source, 
		   new String[] {
			 "name", "import_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getImportType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (metaDataTypeEClass, 
		   source, 
		   new String[] {
			 "name", "metaData_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getMetaDataType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getMetaDataType_MetaValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "metaValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (metaValueTypeEClass, 
		   source, 
		   new String[] {
			 "name", "metaValue_._type",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getMetaValueType_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });
		addAnnotation
		  (packageNameTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "packageName_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });	
		addAnnotation
		  (priorityTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "priority_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#integer",
			 "minInclusive", "1"
		   });			
		addAnnotation
		  (taskNameTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "taskName_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });	
		addAnnotation
		  (versionTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "version_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });
	}

} //DroolsPackageImpl
