package io.fluent.generator.entity.codetemplate;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CodeTemplateInfo {

    private String name;
    private String path;
    private List<CodeTemplateTypeConfig> codeTemplates=new ArrayList<>();
}
