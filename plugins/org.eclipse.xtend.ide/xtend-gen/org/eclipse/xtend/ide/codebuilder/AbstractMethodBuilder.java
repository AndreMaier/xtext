/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractMethodBuilder extends AbstractCodeBuilder {
  private String _methodName;
  
  public String getMethodName() {
    return this._methodName;
  }
  
  public void setMethodName(final String methodName) {
    this._methodName = methodName;
  }
  
  private JvmTypeReference _returnType;
  
  public JvmTypeReference getReturnType() {
    return this._returnType;
  }
  
  public void setReturnType(final JvmTypeReference returnType) {
    this._returnType = returnType;
  }
  
  private List<JvmTypeReference> _parameterTypes = new Function0<List<JvmTypeReference>>() {
    public List<JvmTypeReference> apply() {
      List<JvmTypeReference> _emptyList = CollectionLiterals.<JvmTypeReference>emptyList();
      return _emptyList;
    }
  }.apply();
  
  public List<JvmTypeReference> getParameterTypes() {
    return this._parameterTypes;
  }
  
  public void setParameterTypes(final List<JvmTypeReference> parameterTypes) {
    this._parameterTypes = parameterTypes;
  }
  
  private boolean _staticFlag;
  
  public boolean isStaticFlag() {
    return this._staticFlag;
  }
  
  public void setStaticFlag(final boolean staticFlag) {
    this._staticFlag = staticFlag;
  }
  
  protected IAppendable appendDefaultBody(final IAppendable appendable, final String statementSeparator) {
    IAppendable _append = appendable.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
    IAppendable _append_1 = _append.append(statementSeparator);
    return _append_1;
  }
  
  public String getImage() {
    String _switchResult = null;
    JvmVisibility _visibility = this.getVisibility();
    final JvmVisibility getVisibility = _visibility;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(getVisibility,JvmVisibility.PRIVATE)) {
        _matched=true;
        _switchResult = "methpri_obj.gif";
      }
    }
    if (!_matched) {
      if (Objects.equal(getVisibility,JvmVisibility.PROTECTED)) {
        _matched=true;
        _switchResult = "methpro_obj.gif";
      }
    }
    if (!_matched) {
      if (Objects.equal(getVisibility,JvmVisibility.PUBLIC)) {
        _matched=true;
        _switchResult = "methpub_obj.gif";
      }
    }
    if (!_matched) {
      _switchResult = "methdef_obj.gif";
    }
    return _switchResult;
  }
}