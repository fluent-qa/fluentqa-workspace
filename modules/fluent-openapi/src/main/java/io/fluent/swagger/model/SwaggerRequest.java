package io.fluent.swagger.model;

import java.util.List;
import lombok.Data;

@Data
public class SwaggerRequest {
  private List<String> tags;
  private String summary;
  private String description;
  private String operationId;
  private List<String> consumes;
  private List<String> produces;
  private List<SwaggerParameter> parameters;
}
