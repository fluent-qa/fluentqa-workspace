package io.fluent.postman.model;

import java.util.List;
import lombok.Data;

@Data
public class PostmanScript {
  private List<String> exec;
  private String type;
}
