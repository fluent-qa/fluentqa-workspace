package io.fluent.generator.entity;

import lombok.Data;


@Data
public class FieldInfo {

    private String columnName;
    private String fieldName;
    private String fieldClass;
    private String swaggerClass;
    private String fieldComment;

}
