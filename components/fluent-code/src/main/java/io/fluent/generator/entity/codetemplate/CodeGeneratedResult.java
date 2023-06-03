package io.fluent.generator.entity.codetemplate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CodeGeneratedResult {
    private String filePath;
    private String content;


}
