package io.fluent.generator.entity;

import lombok.Data;

import java.util.List;

@Data
public class ModelInfo {

    private String tableName;
    private String originTableName;
    private String className;
    private String classComment;
    private List<FieldInfo> fieldList;

}
