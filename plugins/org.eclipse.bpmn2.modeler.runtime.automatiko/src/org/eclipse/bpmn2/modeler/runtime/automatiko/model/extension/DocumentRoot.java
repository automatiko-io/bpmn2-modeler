/**
 */
package org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *  
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getImportType <em>Import Type</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getMetaValue <em>Meta Value</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getTaskName <em>Task Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends org.eclipse.bpmn2.DocumentRoot {


	/**
	 * Returns the value of the '<em><b>Import Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Type</em>' containment reference.
	 * @see #setImportType(ImportType)
	 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot_ImportType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace'"
	 * @generated
	 */
	ImportType getImportType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getImportType <em>Import Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Type</em>' containment reference.
	 * @see #getImportType()
	 * @generated
	 */
	void setImportType(ImportType value);

	/**
	 * Returns the value of the '<em><b>Meta Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MetaData</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Data</em>' containment reference.
	 * @see #setMetaData(MetaDataType)
	 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot_MetaData()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='metaData' namespace='##targetNamespace'"
	 * @generated
	 */
	MetaDataType getMetaData();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getMetaData <em>Meta Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Data</em>' containment reference.
	 * @see #getMetaData()
	 * @generated
	 */
	void setMetaData(MetaDataType value);

	/**
	 * Returns the value of the '<em><b>Meta Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MetaValue</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Value</em>' containment reference.
	 * @see #setMetaValue(MetaValueType)
	 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot_MetaValue()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='metaValue' namespace='##targetNamespace'"
	 * @generated
	 */
	MetaValueType getMetaValue();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getMetaValue <em>Meta Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Value</em>' containment reference.
	 * @see #getMetaValue()
	 * @generated
	 */
	void setMetaValue(MetaValueType value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot_PackageName()
	 * @model dataType="org.eclipse.bpmn2.modeler.runtime.automatiko.model.automatiko.PackageNameType"
	 *        extendedMetaData="kind='attribute' name='packageName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(BigInteger)
	 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot_Priority()
	 * @model dataType="org.eclipse.bpmn2.modeler.runtime.automatiko.model.automatiko.PriorityType"
	 *        extendedMetaData="kind='attribute' name='priority' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getPriority();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Task Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Name</em>' attribute.
	 * @see #setTaskName(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot_TaskName()
	 * @model dataType="org.eclipse.bpmn2.modeler.runtime.automatiko.model.automatiko.TaskNameType"
	 *        extendedMetaData="kind='attribute' name='taskName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTaskName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getTaskName <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Name</em>' attribute.
	 * @see #getTaskName()
	 * @generated
	 */
	void setTaskName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.ExtensionPackage#getDocumentRoot_Version()
	 * @model dataType="org.eclipse.bpmn2.modeler.runtime.automatiko.model.automatiko.VersionType"
	 *        extendedMetaData="kind='attribute' name='version' namespace='##targetNamespace'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.automatiko.model.extension.DocumentRoot#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // DocumentRoot
