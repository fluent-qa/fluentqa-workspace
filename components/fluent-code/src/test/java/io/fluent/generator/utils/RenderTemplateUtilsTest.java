package io.fluent.generator.utils;

import cn.hutool.core.map.MapUtil;
import io.fluent.generator.entity.ModelInfo;
import junit.framework.TestCase;
import org.junit.Test;

public class RenderTemplateUtilsTest extends TestCase {

    @Test
    public void testRenderByTemplateString() {
        String templateString = "import java.util.Date;\n" +
                "import java.util.List;\n" +
                "import java.io.Serializable;\n" +
                "import javax.persistence.Column;\n" +
                "import javax.persistence.Entity;\n" +
                "import javax.persistence.Id;\n" +
                "import javax.persistence.Table;\n" +
                "import javax.persistence.GeneratedValue; classname = ${classInfo.originTableName}";
        ModelInfo info = new ModelInfo();
        info.setOriginTableName("Test");

        String result = RenderTemplateUtils.renderByTemplateString(templateString,
                MapUtil.builder().put("classInfo",info).build());
        System.out.println(result);
    }

    public void testRenderByClassPathTemplateFile() {
        ModelInfo info = new ModelInfo();
        info.setOriginTableName("Test");
        String result = RenderTemplateUtils.renderClassPathTemplate("jpa/demo.ftl",
                MapUtil.builder().put("classInfo",info).build());
        System.out.println(result);
    }

    public void testRenderByFile() {
        ModelInfo info = new ModelInfo();
        info.setOriginTableName("Test");
        String result = RenderTemplateUtils.renderFileTemplate("/Users/patrick/workspace/personal/qdriven/fluent-qa/daily-qa/daily-java/fluentqa-workspace/demo.ftl",
                MapUtil.builder().put("classInfo",info).build());
        System.out.println(result);
    }
}