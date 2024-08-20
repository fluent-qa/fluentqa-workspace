package io.fluent.postman.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class PostmanEvent {

  private List<String> variables = new ArrayList<>();

  private List<String> variableValues = new ArrayList<>();
  private String listen;
  private PostmanScript script;
}
