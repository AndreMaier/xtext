package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.Problem;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public abstract class AbstractActiveAnnotationsTest {
  @Test
  public void testSimpleModification() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(typeof(AbstractProcessor))");
    _builder.newLine();
    _builder.append("annotation Abstract { }");
    _builder.newLine();
    _builder.append("class AbstractProcessor implements ModifyProcessor<MutableClassDeclaration> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension ModifyContext ctx");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override modify(List<? extends MutableClassDeclaration> annotatedSourceClasses, ModifyContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctx = context");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedSourceClasses.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("^abstract = true");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/AbstractAnnotation.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@myannotation.Abstract");
    _builder_1.newLine();
    _builder_1.append("class MyClass {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
        public void apply(final CompilationUnitImpl it) {
          List<? extends ClassDeclaration> _generatedClassDeclarations = it.getGeneratedClassDeclarations();
          final ClassDeclaration clazz = IterableExtensions.head(_generatedClassDeclarations);
          boolean _isAbstract = clazz.isAbstract();
          Assert.assertTrue(_isAbstract);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  @Test
  public void testPropertyAnnotation() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/PropertyAnnotation.xtend", "\n\t\t\t\tpackage myannotation\n\t\t\t\t\n\t\t\t\timport java.util.List\n\t\t\t\timport org.eclipse.xtend.lib.macro.Active\n\t\t\t\timport org.eclipse.xtend.lib.macro.ModifyContext\n\t\t\t\timport org.eclipse.xtend.lib.macro.ModifyProcessor\n\t\t\t\timport org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration\n\n\t\t\t\t@Active(typeof(PropertyProcessor))\n\t\t\t\tannotation Property2 { }\n\t\t\t\tclass PropertyProcessor implements ModifyProcessor<MutableFieldDeclaration> {\n\t\t\t\t\t\n\t\t\t\t\textension ModifyContext ctx\n\t\t\t\t\t\n\t\t\t\t\toverride modify(List<? extends MutableFieldDeclaration> annotatedSourceFields, ModifyContext context) {\n\t\t\t\t\t\tctx = context\n\t\t\t\t\t\tannotatedSourceFields.forEach [ field |\n\t\t\t\t\t\t\tfield.declaringType.addMethod(field.getterName) [\n\t\t\t\t\t\t\t\treturnType = field.type\n\t\t\t\t\t\t\t\tbody = [\'\'\'\n\t\t\t\t\t\t\t\t\treturn this.\u00ABfield.name\u00BB;\n\t\t\t\t\t\t\t\t\'\'\']\n\t\t\t\t\t\t\t]\n\t\t\t\t\t\t\tfield.declaringType.addMethod(\'set\'+field.name.toFirstUpper) [\n\t\t\t\t\t\t\t\taddParameter(field.name, field.type)\n\t\t\t\t\t\t\t\tbody = [\'\'\'\n\t\t\t\t\t\t\t\t\tthis.\u00ABfield.name\u00BB = \u00ABfield.name\u00BB;\n\t\t\t\t\t\t\t\t\'\'\']\n\t\t\t\t\t\t\t]\n\t\t\t\t\t\t]\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tdef private String getterName(MutableFieldDeclaration field) {\n\t\t\t\t\t\treturn \'get\'+field.name.toFirstUpper\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myusercode");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@myannotation.Property2 String myField");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder.toString());
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
        public void apply(final CompilationUnitImpl it) {
          List<? extends ClassDeclaration> _generatedClassDeclarations = it.getGeneratedClassDeclarations();
          final ClassDeclaration clazz = IterableExtensions.head(_generatedClassDeclarations);
          List<? extends MemberDeclaration> _members = clazz.getMembers();
          Iterable<MutableMethodDeclaration> _filter = Iterables.<MutableMethodDeclaration>filter(_members, MutableMethodDeclaration.class);
          final MutableMethodDeclaration getter = IterableExtensions.<MutableMethodDeclaration>head(_filter);
          String _name = getter.getName();
          Assert.assertEquals("getMyField", _name);
          TypeReference _returnType = getter.getReturnType();
          String _string = _returnType.toString();
          Assert.assertEquals("String", _string);
          List<? extends MemberDeclaration> _members_1 = clazz.getMembers();
          Iterable<MutableMethodDeclaration> _filter_1 = Iterables.<MutableMethodDeclaration>filter(_members_1, MutableMethodDeclaration.class);
          Iterable<MutableMethodDeclaration> _drop = IterableExtensions.<MutableMethodDeclaration>drop(_filter_1, 1);
          final MutableMethodDeclaration setter = IterableExtensions.<MutableMethodDeclaration>head(_drop);
          String _name_1 = setter.getName();
          Assert.assertEquals("setMyField", _name_1);
          TypeReference _returnType_1 = setter.getReturnType();
          String _string_1 = _returnType_1.toString();
          Assert.assertEquals("void", _string_1);
          List<MutableParameterDeclaration> _parameters = setter.getParameters();
          MutableParameterDeclaration _head = IterableExtensions.<MutableParameterDeclaration>head(_parameters);
          String _name_2 = _head.getName();
          Assert.assertEquals("myField", _name_2);
          List<MutableParameterDeclaration> _parameters_1 = setter.getParameters();
          MutableParameterDeclaration _head_1 = IterableExtensions.<MutableParameterDeclaration>head(_parameters_1);
          TypeReference _type = _head_1.getType();
          String _string_2 = _type.toString();
          Assert.assertEquals("String", _string_2);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  @Test
  public void testThrowsAndTypeParam() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(typeof(ThrowsAndTypeParamProcessor))");
    _builder.newLine();
    _builder.append("annotation ThrowsAndTypeParam { }");
    _builder.newLine();
    _builder.append("class ThrowsAndTypeParamProcessor implements ModifyProcessor<MutableMethodDeclaration> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension ModifyContext ctx");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override modify(List<? extends MutableMethodDeclaration> annotatedMethods, ModifyContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctx = context");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedMethods.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val type = addTypeParameter(\'A\')");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("addParameter(\'myParam\', typeReferenceProvider.newTypeReference(type))");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("setExceptions(typeReferenceProvider.newTypeReference(\'java.lang.Exception\'))");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/AbstractAnnotation.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyClass {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@myannotation.ThrowsAndTypeParam");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void foo(){");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
        public void apply(final CompilationUnitImpl it) {
          List<? extends ClassDeclaration> _generatedClassDeclarations = it.getGeneratedClassDeclarations();
          ClassDeclaration _head = IterableExtensions.head(_generatedClassDeclarations);
          List<? extends MemberDeclaration> _members = _head.getMembers();
          Iterable<MutableMethodDeclaration> _filter = Iterables.<MutableMethodDeclaration>filter(_members, MutableMethodDeclaration.class);
          final MutableMethodDeclaration method = IterableExtensions.<MutableMethodDeclaration>head(_filter);
          List<MutableTypeParameterDeclaration> _typeParameters = method.getTypeParameters();
          MutableTypeParameterDeclaration _head_1 = IterableExtensions.<MutableTypeParameterDeclaration>head(_typeParameters);
          String _name = _head_1.getName();
          Assert.assertEquals("A", _name);
          List<MutableParameterDeclaration> _parameters = method.getParameters();
          MutableParameterDeclaration _head_2 = IterableExtensions.<MutableParameterDeclaration>head(_parameters);
          String _name_1 = _head_2.getName();
          Assert.assertEquals("myParam", _name_1);
          List<MutableTypeParameterDeclaration> _typeParameters_1 = method.getTypeParameters();
          MutableTypeParameterDeclaration _head_3 = IterableExtensions.<MutableTypeParameterDeclaration>head(_typeParameters_1);
          List<MutableParameterDeclaration> _parameters_1 = method.getParameters();
          MutableParameterDeclaration _head_4 = IterableExtensions.<MutableParameterDeclaration>head(_parameters_1);
          TypeReference _type = _head_4.getType();
          Type _type_1 = _type.getType();
          Assert.assertSame(_head_3, _type_1);
          List<TypeReference> _exceptions = method.getExceptions();
          int _size = _exceptions.size();
          Assert.assertEquals(1, _size);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  @Test
  public void testValidation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.ModifyProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(typeof(ValidatedProcessor))");
    _builder.newLine();
    _builder.append("annotation Validated { }");
    _builder.newLine();
    _builder.append("class ValidatedProcessor implements ModifyProcessor<MutableNamedElement> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension ModifyContext ctx");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override modify(List<? extends MutableNamedElement> annotatedMethods, ModifyContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctx = context");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedMethods.forEach [ ele |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("switch ele {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("MutableFieldDeclaration : ele.addWarning(\'field-warning\')");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("default : ele.addWarning(\'warning\')");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/AbstractAnnotation.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyClass {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@myannotation.Validated");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@myannotation.Validated");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("String name");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
        public void apply(final CompilationUnitImpl it) {
          List<? extends ClassDeclaration> _generatedClassDeclarations = it.getGeneratedClassDeclarations();
          ClassDeclaration _head = IterableExtensions.head(_generatedClassDeclarations);
          List<? extends MemberDeclaration> _members = _head.getMembers();
          Iterable<MutableMethodDeclaration> _filter = Iterables.<MutableMethodDeclaration>filter(_members, MutableMethodDeclaration.class);
          final MutableMethodDeclaration method = IterableExtensions.<MutableMethodDeclaration>head(_filter);
          List<? extends ClassDeclaration> _generatedClassDeclarations_1 = it.getGeneratedClassDeclarations();
          ClassDeclaration _head_1 = IterableExtensions.head(_generatedClassDeclarations_1);
          List<? extends MemberDeclaration> _members_1 = _head_1.getMembers();
          Iterable<MutableFieldDeclaration> _filter_1 = Iterables.<MutableFieldDeclaration>filter(_members_1, MutableFieldDeclaration.class);
          final MutableFieldDeclaration field = IterableExtensions.<MutableFieldDeclaration>head(_filter_1);
          List<Problem> _problems = it.getProblems(field);
          Problem _head_2 = IterableExtensions.<Problem>head(_problems);
          String _message = _head_2.getMessage();
          Assert.assertEquals("field-warning", _message);
          List<Problem> _problems_1 = it.getProblems(method);
          Problem _head_3 = IterableExtensions.<Problem>head(_problems_1);
          String _message_1 = _head_3.getMessage();
          Assert.assertEquals("warning", _message_1);
        }
      };
    this.assertProcessing(_mappedTo, _mappedTo_1, _function);
  }
  
  public abstract void assertProcessing(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super CompilationUnitImpl> expectations);
}