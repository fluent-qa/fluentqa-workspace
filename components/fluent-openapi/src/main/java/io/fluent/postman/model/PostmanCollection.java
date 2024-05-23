package io.fluent.postman.model;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class PostmanCollection {

  private PostmanCollectionInfo info;
  private List<PostmanItem> item;
  private List<PostmanKeyValue> variable;
  private Map<String, Object> auth;
}
