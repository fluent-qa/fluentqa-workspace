package io.fluent.generator.utils;

import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import cn.hutool.extra.template.engine.freemarker.FreemarkerEngine;
import io.fluent.builtin.FileUtils;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.function.Function;

public class RenderTemplateUtils extends TemplateUtil {
    static TemplateEngine stringEngine = TemplateUtil.createEngine(new TemplateConfig("",
            TemplateConfig.ResourceMode.STRING));

    static FreemarkerEngine freemarkerEngine = (FreemarkerEngine) TemplateUtil.createEngine(new TemplateConfig(
            "templates/codes", TemplateConfig.ResourceMode.CLASSPATH
    ));

    public static String renderByTemplateString(String tplString, Map contextData) {
        Template template = stringEngine.getTemplate(tplString);
        return template.render(contextData);
    }

    public static String renderClassPathTemplate(String templateFile, Map contextData) {

        Template template = freemarkerEngine.getTemplate(templateFile);
        return template.render(contextData);
    }

    public static String renderFileTemplate(String tplFilePath, Map contextData) {
        String templatesStr = FileUtils.readString(tplFilePath, Charset.defaultCharset());
        return renderByTemplateString(templatesStr, contextData);
    }

    public static <T> String renderBy(T byWhat,Function<T,String> getTemplateStrFucByWhat,Map contextData){
        String templateStr = getTemplateStrFucByWhat.apply(byWhat);
        return renderByTemplateString(templateStr,contextData);
    }
}
