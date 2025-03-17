package io.fluent.mindmap.freemind;

import io.fluent.builtin.XmlUtils;
import io.fluent.mindmap.api.MindMapConvertConfig;
import io.fluent.mindmap.api.MindMapPath;
import io.fluent.mindmap.api.MindMapPathRecord;
import io.fluent.mindmap.api.MindMapTransformer;
import io.fluent.mindmap.freemind.model.Map;
import io.fluent.mindmap.freemind.model.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** 1. READ FreeMind Files 2. Convert */
public class FreeMindTransformer implements MindMapTransformer<Node> {

  @Override
  public List<MindMapPath<Node>> readMindMapToList(String mindMapContent) {
    return convertToList(mindMapContent);
  }

  @Override
  public <T> List<T> readMindMapToList(String mindMapPath, Class<T> clazz) {
    List<MindMapPath<Node>> paths = convertToList(mindMapPath);
    List<MindMapPathRecord> records = MindMapPathRecord.fromMindMapPaths(paths, Node::getTEXT);
    return records.stream()
        .map(mindMapPathRecord -> mindMapPathRecord.toBean(clazz))
        .collect(Collectors.toList());
  }

  @Override
  public <T> List<T> readMindMapToList(
      String mindMapPath, Class<T> clazz, MindMapConvertConfig config) {
    List<MindMapPath<Node>> paths = convertToList(mindMapPath);
    List<MindMapPathRecord> records = MindMapPathRecord.fromMindMapPaths(paths, Node::getTEXT);
    return records.stream()
        .map(mindMapPathRecord -> mindMapPathRecord.toBean(clazz, config))
        .collect(Collectors.toList());
  }

  private List<MindMapPath<Node>> convertToList(String mindmapFilePath) {
    Map freeMindMap = XmlUtils.readXmlToObject(XmlUtils.readXML(mindmapFilePath), Map.class);
    FreeMindNode root = new FreeMindNode(freeMindMap.getNode());
    List<MindMapPath<Node>> result = new ArrayList<>();
    populateNodes(List.of(root), result);
    return result;
  }

  /**
   * ->Node1 currentNode | ->Node2 convert to: [ currentNode->Node1, currentNode->Node2]
   *
   * @param current: Current Node
   * @return OUT: A List of MindMapPath
   */
  private List<MindMapPath<Node>> populateNextLevel(MindMapPath<Node> current) {
    Node lastNode = current.pathNodes().getLast();
    List<MindMapPath<Node>> mindMapPaths = new ArrayList<>();
    for (Object o : lastNode.getArrowlinkOrAttributeOrAttributeLayout()) {
      MindMapPath<Node> path = current.clone();
      if (o instanceof Node) {
        path.pathNodes().add((Node) o);
      }
      mindMapPaths.add(path);
    }

    return mindMapPaths;
  }

  private void populateNodes(List<MindMapPath<Node>> nodes, List<MindMapPath<Node>> resultPaths) {

    for (MindMapPath<Node> current : nodes) {
      if (current.pathNodes().getLast().getArrowlinkOrAttributeOrAttributeLayout().size() == 0) {
        resultPaths.add(current);
      } else {
        populateNodes(populateNextLevel(current), resultPaths);
      }
    }
  }
}
