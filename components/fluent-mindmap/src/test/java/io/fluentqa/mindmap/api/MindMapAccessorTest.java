package io.fluentqa.mindmap.api;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MindMapAccessorTest {
    MindMapAccessor accessor = new MindMapAccessor();
    @Test
    public void testMindMapAccessorTest(){
        String xmindFile = "./Xmind10+.xmind";
        List<DemoBean> freeMindBeans = accessor.readMindMapToBean(xmindFile,DemoBean.class);
        System.out.println(freeMindBeans);
    }

    @Test
    public void testFreeMindBeanConfigAccessorTest(){
        String freeMindfile = "./元件管理用例.mm";
        List<DemoBeanWOLevel> freeMindBeans = accessor.readMindMapToBean(freeMindfile,DemoBeanWOLevel.class,DemoBeanConfig.loadConfig());
        System.out.println(freeMindBeans);
    }
}
