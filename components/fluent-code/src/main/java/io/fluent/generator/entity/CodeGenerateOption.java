package io.fluent.generator.entity;

import io.fluent.generator.entity.codetemplate.CodeTemplateInfo;
import lombok.Data;

/**
 * 1. Table DDL
 * 2. Schema/Table Name
 * 3. Entity Class Info
 */

@Data
public class CodeGenerateOption {

    private String packageName;
    private ModelInfo modelInfo;
    private String language;
    private String databaseType;
    private CodeTemplateInfo templateInfo;

    @Data
    public static class NAME_CASE_TYPE {
        public static String CAMEL_CASE = "CamelCase";
        public static String UNDER_SCORE_CASE = "UnderScoreCase";
        public static String UPPER_UNDER_SCORE_CASE = "UpperUnderScoreCase";
    }

}
