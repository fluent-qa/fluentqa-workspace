package io.fluentqa.mindmap.freemind;

import io.fluentqa.mindmap.api.MindMapPath;
import io.fluentqa.mindmap.freemind.model.Node;

public class FreeMindNode extends MindMapPath<Node> {

  public FreeMindNode(Node root) {
    super(root);
  }

  /**
   * COPY nodes in new LinedList
   *
   * @return
   */
  //    @Override
  //    protected FreeMindNode clone() {
  //        FreeMindNode path = new FreeMindNode(this.getRoot());
  //        path.setPathNodes((LinkedList<Node>) this.getPathNodes().clone());
  //        return path;
  //    }

}
