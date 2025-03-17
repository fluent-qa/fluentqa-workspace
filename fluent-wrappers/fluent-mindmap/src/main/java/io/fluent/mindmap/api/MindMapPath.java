package io.fluent.mindmap.api;

import java.util.LinkedList;
import lombok.Data;

@Data
public class MindMapPath<T> implements Cloneable {
  private T root;

  private LinkedList<T> pathNodes = new LinkedList<>();

  public MindMapPath(T root) {
    this.root = root;
    this.pathNodes.add(root);
  }

  public T root() {
    return root;
  }

  public LinkedList<T> pathNodes() {
    return this.pathNodes;
  }

  @Override
  public MindMapPath<T> clone() {
    MindMapPath<T> path = new MindMapPath<T>(this.getRoot());
    path.setPathNodes((LinkedList<T>) this.pathNodes.clone());
    return path;
  }
}
