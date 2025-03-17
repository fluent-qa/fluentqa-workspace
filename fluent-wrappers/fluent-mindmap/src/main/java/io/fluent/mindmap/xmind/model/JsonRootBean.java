package io.fluent.mindmap.xmind.model;

import lombok.Data;

@Data
public class JsonRootBean {

  private String id;
  private String title;
  private RootTopic rootTopic;
}
