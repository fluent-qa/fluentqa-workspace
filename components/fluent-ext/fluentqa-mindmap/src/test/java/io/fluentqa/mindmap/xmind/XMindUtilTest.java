package io.fluentqa.mindmap.xmind;

import io.fluentqa.mindmap.xmind.model.XmindRawData;
import org.junit.jupiter.api.Test;

class XMindUtilTest {

    @Test
    void readXMindFile_ZEN() {
        XmindRawData data = XMindUtil.readXMindFile("./XmindZen.xmind");
        System.out.println(data);
    }

    @Test
    void readXMindFile_XMIND() {
        XmindRawData data = XMindUtil.readXMindFile("./Xmind10+.xmind");
        System.out.println(data);
    }

    @Test
    void readXMindFile_XMIND8() {
        XmindRawData data = XMindUtil.readXMindFile("./Xmind8.xmind");
        System.out.println(data);
    }

}