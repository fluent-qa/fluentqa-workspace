package io.fluent.mindmap.xmind;

import io.fluent.mindmap.xmind.model.Attached;
import io.fluent.mindmap.api.MindMapPath;

public class XMindNode extends MindMapPath<Attached> implements Cloneable {
  public XMindNode(Attached root) {
    super(root);
  }
}
