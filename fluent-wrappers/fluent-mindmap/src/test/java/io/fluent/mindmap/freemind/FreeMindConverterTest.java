package io.fluent.mindmap.freemind;

import io.fluent.mindmap.api.MindMapPath;
import io.fluent.mindmap.freemind.model.Node;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;

public class FreeMindConverterTest {
  @BeforeEach
  public void setup() {}

  @org.junit.jupiter.api.Test
  void testToList() {
    FreeMindTransformer converter = new FreeMindTransformer();
    List<MindMapPath<Node>> result = converter.readMindMapToList("./t2.mm");
    System.out.println(result);
  }
}
