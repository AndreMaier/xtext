/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtype.XtypeFactory
 * @model kind="package"
 * @generated
 */
public interface XtypePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xtype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/xbase/Xtype";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xtype";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtypePackage eINSTANCE = org.eclipse.xtext.xtype.impl.XtypePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
	 * @generated
	 */
	int XFUNCTION_TYPE_REF = 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__ARGUMENTS = TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__TYPE = TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Param Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__PARAM_TYPES = TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__RETURN_TYPE = TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XFunction Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF_FEATURE_COUNT = TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XSynonymTypeReferenceImpl <em>XSynonym Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.XSynonymTypeReferenceImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXSynonymTypeReference()
	 * @generated
	 */
	int XSYNONYM_TYPE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Synonymes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSYNONYM_TYPE_REFERENCE__SYNONYMES = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSYNONYM_TYPE_REFERENCE__TYPE = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XSynonym Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSYNONYM_TYPE_REFERENCE_FEATURE_COUNT = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XDelegateTypeReferenceImpl <em>XDelegate Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtype.impl.XDelegateTypeReferenceImpl
	 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXDelegateTypeReference()
	 * @generated
	 */
	int XDELEGATE_TYPE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDELEGATE_TYPE_REFERENCE__DELEGATE = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XDelegate Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDELEGATE_TYPE_REFERENCE_FEATURE_COUNT = TypesPackage.JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XFunctionTypeRef <em>XFunction Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFunction Type Ref</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef
	 * @generated
	 */
	EClass getXFunctionTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes <em>Param Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param Types</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_ParamTypes();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XSynonymTypeReference <em>XSynonym Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSynonym Type Reference</em>'.
	 * @see org.eclipse.xtext.xtype.XSynonymTypeReference
	 * @generated
	 */
	EClass getXSynonymTypeReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.XSynonymTypeReference#getSynonymes <em>Synonymes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Synonymes</em>'.
	 * @see org.eclipse.xtext.xtype.XSynonymTypeReference#getSynonymes()
	 * @see #getXSynonymTypeReference()
	 * @generated
	 */
	EReference getXSynonymTypeReference_Synonymes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xtype.XSynonymTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xtype.XSynonymTypeReference#getType()
	 * @see #getXSynonymTypeReference()
	 * @generated
	 */
	EReference getXSynonymTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XDelegateTypeReference <em>XDelegate Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XDelegate Type Reference</em>'.
	 * @see org.eclipse.xtext.xtype.XDelegateTypeReference
	 * @generated
	 */
	EClass getXDelegateTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xtype.XDelegateTypeReference#getDelegate <em>Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delegate</em>'.
	 * @see org.eclipse.xtext.xtype.XDelegateTypeReference#getDelegate()
	 * @see #getXDelegateTypeReference()
	 * @generated
	 */
	EReference getXDelegateTypeReference_Delegate();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XtypeFactory getXtypeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
		 * @generated
		 */
		EClass XFUNCTION_TYPE_REF = eINSTANCE.getXFunctionTypeRef();

		/**
		 * The meta object literal for the '<em><b>Param Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__PARAM_TYPES = eINSTANCE.getXFunctionTypeRef_ParamTypes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__RETURN_TYPE = eINSTANCE.getXFunctionTypeRef_ReturnType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XSynonymTypeReferenceImpl <em>XSynonym Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XSynonymTypeReferenceImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXSynonymTypeReference()
		 * @generated
		 */
		EClass XSYNONYM_TYPE_REFERENCE = eINSTANCE.getXSynonymTypeReference();

		/**
		 * The meta object literal for the '<em><b>Synonymes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSYNONYM_TYPE_REFERENCE__SYNONYMES = eINSTANCE.getXSynonymTypeReference_Synonymes();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSYNONYM_TYPE_REFERENCE__TYPE = eINSTANCE.getXSynonymTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XDelegateTypeReferenceImpl <em>XDelegate Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtype.impl.XDelegateTypeReferenceImpl
		 * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXDelegateTypeReference()
		 * @generated
		 */
		EClass XDELEGATE_TYPE_REFERENCE = eINSTANCE.getXDelegateTypeReference();

		/**
		 * The meta object literal for the '<em><b>Delegate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XDELEGATE_TYPE_REFERENCE__DELEGATE = eINSTANCE.getXDelegateTypeReference_Delegate();

	}

} //XtypePackage
