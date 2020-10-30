/**
 */
package org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl;

import java.math.BigInteger;

import org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.DocumentRoot;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.ExtensionPackage;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.ImportType;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.MetaDataType;
import org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.MetaValueType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl.DocumentRootImpl#getImportType <em>Import Type</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl.DocumentRootImpl#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl.DocumentRootImpl#getMetaValue <em>Meta Value</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl.DocumentRootImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl.DocumentRootImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl.DocumentRootImpl#getTaskName <em>Task Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.modeler.runtime.automatik.model.extension.impl.DocumentRootImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends org.eclipse.bpmn2.impl.DocumentRootImpl implements DocumentRoot {
	/**
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected BigInteger priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskName() <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskName()
	 * @generated
	 * @ordered
	 */
	protected static final String TASK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskName() <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskName()
	 * @generated
	 * @ordered
	 */
	protected String taskName = TASK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensionPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportType getImportType() {
		return (ImportType)getMixed().get(ExtensionPackage.Literals.DOCUMENT_ROOT__IMPORT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImportType(ImportType newImportType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ExtensionPackage.Literals.DOCUMENT_ROOT__IMPORT_TYPE, newImportType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportType(ImportType newImportType) {
		((FeatureMap.Internal)getMixed()).set(ExtensionPackage.Literals.DOCUMENT_ROOT__IMPORT_TYPE, newImportType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataType getMetaData() {
		return (MetaDataType)getMixed().get(ExtensionPackage.Literals.DOCUMENT_ROOT__META_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetaData(MetaDataType newMetaData, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ExtensionPackage.Literals.DOCUMENT_ROOT__META_DATA, newMetaData, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaData(MetaDataType newMetaData) {
		((FeatureMap.Internal)getMixed()).set(ExtensionPackage.Literals.DOCUMENT_ROOT__META_DATA, newMetaData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaValueType getMetaValue() {
		return (MetaValueType)getMixed().get(ExtensionPackage.Literals.DOCUMENT_ROOT__META_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetaValue(MetaValueType newMetaValue, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ExtensionPackage.Literals.DOCUMENT_ROOT__META_VALUE, newMetaValue, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaValue(MetaValueType newMetaValue) {
		((FeatureMap.Internal)getMixed()).set(ExtensionPackage.Literals.DOCUMENT_ROOT__META_VALUE, newMetaValue);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionPackage.DOCUMENT_ROOT__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(BigInteger newPriority) {
		BigInteger oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionPackage.DOCUMENT_ROOT__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskName(String newTaskName) {
		String oldTaskName = taskName;
		taskName = newTaskName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionPackage.DOCUMENT_ROOT__TASK_NAME, oldTaskName, taskName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionPackage.DOCUMENT_ROOT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExtensionPackage.DOCUMENT_ROOT__IMPORT_TYPE:
				return basicSetImportType(null, msgs);
			case ExtensionPackage.DOCUMENT_ROOT__META_DATA:
				return basicSetMetaData(null, msgs);
			case ExtensionPackage.DOCUMENT_ROOT__META_VALUE:
				return basicSetMetaValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtensionPackage.DOCUMENT_ROOT__IMPORT_TYPE:
				return getImportType();
			case ExtensionPackage.DOCUMENT_ROOT__META_DATA:
				return getMetaData();
			case ExtensionPackage.DOCUMENT_ROOT__META_VALUE:
				return getMetaValue();
			case ExtensionPackage.DOCUMENT_ROOT__PACKAGE_NAME:
				return getPackageName();
			case ExtensionPackage.DOCUMENT_ROOT__PRIORITY:
				return getPriority();
			case ExtensionPackage.DOCUMENT_ROOT__TASK_NAME:
				return getTaskName();
			case ExtensionPackage.DOCUMENT_ROOT__VERSION:
				return getVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExtensionPackage.DOCUMENT_ROOT__IMPORT_TYPE:
				setImportType((ImportType)newValue);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__META_DATA:
				setMetaData((MetaDataType)newValue);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__META_VALUE:
				setMetaValue((MetaValueType)newValue);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__PRIORITY:
				setPriority((BigInteger)newValue);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__TASK_NAME:
				setTaskName((String)newValue);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__VERSION:
				setVersion((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExtensionPackage.DOCUMENT_ROOT__IMPORT_TYPE:
				setImportType((ImportType)null);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__META_DATA:
				setMetaData((MetaDataType)null);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__META_VALUE:
				setMetaValue((MetaValueType)null);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__TASK_NAME:
				setTaskName(TASK_NAME_EDEFAULT);
				return;
			case ExtensionPackage.DOCUMENT_ROOT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExtensionPackage.DOCUMENT_ROOT__IMPORT_TYPE:
				return getImportType() != null;
			case ExtensionPackage.DOCUMENT_ROOT__META_DATA:
				return getMetaData() != null;
			case ExtensionPackage.DOCUMENT_ROOT__META_VALUE:
				return getMetaValue() != null;
			case ExtensionPackage.DOCUMENT_ROOT__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case ExtensionPackage.DOCUMENT_ROOT__PRIORITY:
				return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
			case ExtensionPackage.DOCUMENT_ROOT__TASK_NAME:
				return TASK_NAME_EDEFAULT == null ? taskName != null : !TASK_NAME_EDEFAULT.equals(taskName);
			case ExtensionPackage.DOCUMENT_ROOT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (packageName: ");
		result.append(packageName);
		result.append(", priority: ");
		result.append(priority);
		result.append(", taskName: ");
		result.append(taskName);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
