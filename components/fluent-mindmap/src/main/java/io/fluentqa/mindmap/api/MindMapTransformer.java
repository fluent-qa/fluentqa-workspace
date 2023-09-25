package io.fluentqa.mindmap.api;

import java.util.List;

public interface MindMapTransformer<Node> {
    public List<MindMapPath<Node>> readMindMapToList(String mindMapPath);
    public <T> List<T> readMindMapToList(String mindMapPath,Class<T> clazz);
    public <T> List<T> readMindMapToList(String mindMapPath,Class<T> clazz,MindMapConvertConfig config);



}
