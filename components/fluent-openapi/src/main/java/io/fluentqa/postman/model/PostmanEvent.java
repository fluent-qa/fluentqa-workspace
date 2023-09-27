package io.fluentqa.postman.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostmanEvent {


  private List<String> variables = new ArrayList<>();


  private List<String> variableValues = new ArrayList<>();
    private String listen;
    private PostmanScript script;
}
