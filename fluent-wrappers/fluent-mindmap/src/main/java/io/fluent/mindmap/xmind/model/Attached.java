package io.fluent.mindmap.xmind.model;

import java.util.List;
import lombok.Data;

@Data
public class Attached {

  private String id;
  private String title;
  private Notes notes;
  private List<Comments> comments;
  private Children children;
}
