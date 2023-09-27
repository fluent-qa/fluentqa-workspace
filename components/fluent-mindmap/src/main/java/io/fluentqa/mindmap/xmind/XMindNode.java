package io.fluentqa.mindmap.xmind;

import io.fluentqa.mindmap.api.MindMapPath;
import io.fluentqa.mindmap.xmind.model.Attached;



public class XMindNode extends MindMapPath<Attached> implements Cloneable {
    public XMindNode(Attached root) {
        super(root);
    }
}
