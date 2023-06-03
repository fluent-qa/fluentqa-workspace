package io.fluent.generator.service;

import com.google.common.collect.Lists;
import io.fluent.generator.entity.CodeGenerateOption;
import io.fluent.generator.entity.FieldInfo;
import io.fluent.generator.entity.ModelInfo;
import junit.framework.TestCase;

public class CodeTemplateServiceTest extends TestCase {
    CodeTemplateService service = new CodeTemplateService();
    public void testGenerateTemplate() {
        CodeGenerateOption codeGenerateOption = new CodeGenerateOption();
        codeGenerateOption.setPackageName("io.test.modules");
        codeGenerateOption.setLanguage("java");
        codeGenerateOption.setDatabaseType("postgresql");
        ModelInfo modelInfo = new ModelInfo();
        modelInfo.setClassName("ModelEntity");
        modelInfo.setTableName("model_entity");
        FieldInfo fieldInfo = new FieldInfo();
        fieldInfo.setFieldName("testName");
        fieldInfo.setColumnName("test_name");
        fieldInfo.setFieldClass("String");
        fieldInfo.setFieldComment("field-comments");
        modelInfo.setFieldList(Lists.newArrayList(fieldInfo));
        

    }
}