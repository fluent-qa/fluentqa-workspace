package io.fluent.generator.service;

import cn.hutool.core.bean.BeanUtil;
import io.fluent.generator.entity.CodeGenerateOption;
import io.fluent.generator.entity.codetemplate.CodeGeneratedResult;
import io.fluent.generator.entity.codetemplate.CodeTemplateTypeConfig;
import io.fluent.generator.utils.RenderTemplateUtils;

import java.util.ArrayList;
import java.util.List;

public class CodeTemplateService {

    public List<CodeGeneratedResult> generateTemplate(CodeGenerateOption generateOption){
        List<CodeTemplateTypeConfig> templatesConfig = generateOption.getTemplateInfo().getCodeTemplates();
        List<CodeGeneratedResult> results = new ArrayList<>();
        for (CodeTemplateTypeConfig codeTemplateTypeConfig : templatesConfig) {
            String content = "";
            if(codeTemplateTypeConfig.getTemplateFilePath()!=null){
                content =  RenderTemplateUtils.renderClassPathTemplate(codeTemplateTypeConfig.getTemplateFilePath(),
                        BeanUtil.beanToMap(generateOption));

            }else {
                content =  RenderTemplateUtils.renderFileTemplate(codeTemplateTypeConfig.getTemplateFilePath(),
                        BeanUtil.beanToMap(generateOption));

            }

            results.add(CodeGeneratedResult.builder().filePath(codeTemplateTypeConfig.getTemplateFilePath())
                    .content(content).build());
        }
        return results;
    }
}
