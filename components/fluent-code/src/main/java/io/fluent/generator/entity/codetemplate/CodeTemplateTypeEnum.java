package io.fluent.generator.entity.codetemplate;

public enum CodeTemplateTypeEnum {
    ENTITY("entity.ftl"),
    Service("service.ftl"),
    Repository("repository.ftl"),
    Controller("controller.ftl")

    ;
    private String templateFileName;
    CodeTemplateTypeEnum(String templateFileName) {
        this.templateFileName = templateFileName;
    }
}
