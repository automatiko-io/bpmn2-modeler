/**
 */
package org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getScenarioParameters <em>Scenario Parameters</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getElementParameters <em>Element Parameters</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getCalendar <em>Calendar</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getVendorExtension <em>Vendor Extension</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getCreated <em>Created</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getInherits <em>Inherits</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getModified <em>Modified</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getVendor <em>Vendor</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario()
 * @model extendedMetaData="name='Scenario' kind='elementOnly'"
 * @generated
 */
public interface Scenario extends EObject {
	/**
	 * Returns the value of the '<em><b>Scenario Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario Parameters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario Parameters</em>' containment reference.
	 * @see #setScenarioParameters(ScenarioParameters)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_ScenarioParameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ScenarioParameters' namespace='##targetNamespace'"
	 * @generated
	 */
	ScenarioParameters getScenarioParameters();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getScenarioParameters <em>Scenario Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario Parameters</em>' containment reference.
	 * @see #getScenarioParameters()
	 * @generated
	 */
	void setScenarioParameters(ScenarioParameters value);

	/**
	 * Returns the value of the '<em><b>Element Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ElementParameters}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Parameters</em>' containment reference list.
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_ElementParameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ElementParameters' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ElementParameters> getElementParameters();

	/**
	 * Returns the value of the '<em><b>Calendar</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Calendar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calendar</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calendar</em>' containment reference list.
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Calendar()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Calendar' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Calendar> getCalendar();

	/**
	 * Returns the value of the '<em><b>Vendor Extension</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.VendorExtension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vendor Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vendor Extension</em>' containment reference list.
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_VendorExtension()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='VendorExtension' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<VendorExtension> getVendorExtension();

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Author()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='author'"
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(XMLGregorianCalendar)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Created()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='created'"
	 * @generated
	 */
	XMLGregorianCalendar getCreated();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Id()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Inherits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherits</em>' attribute.
	 * @see #setInherits(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Inherits()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='inherits'"
	 * @generated
	 */
	String getInherits();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getInherits <em>Inherits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherits</em>' attribute.
	 * @see #getInherits()
	 * @generated
	 */
	void setInherits(String value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' attribute.
	 * @see #setModified(XMLGregorianCalendar)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Modified()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='modified'"
	 * @generated
	 */
	XMLGregorianCalendar getModified();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #getModified()
	 * @generated
	 */
	void setModified(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Result()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='result'"
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

	/**
	 * Returns the value of the '<em><b>Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vendor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vendor</em>' attribute.
	 * @see #setVendor(String)
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Vendor()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='vendor'"
	 * @generated
	 */
	String getVendor();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getVendor <em>Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vendor</em>' attribute.
	 * @see #getVendor()
	 * @generated
	 */
	void setVendor(String value);

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
	 * @see org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.ModelPackage#getScenario_Version()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='version'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.modeler.runtime.jboss.jbpm5.model.Scenario#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // Scenario
