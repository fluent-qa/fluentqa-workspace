package io.fluent.mindmap.xmind;

import io.fluent.mindmap.api.MindMapPath;
import io.fluent.mindmap.xmind.model.Attached;

import java.util.List;
import org.junit.jupiter.api.Test;

class XmindTransformerTest {
  XmindTransformer xmindTransformer = new XmindTransformer();

  @Test
  void convertFromFileContent() {}

  @Test
  void convertFromFilePath() {
    List<MindMapPath<Attached>> result = xmindTransformer.readMindMapToList("./Xmind10+.xmind");
    System.out.println(result);
  }
}
