package io.fluent.postman.model;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PostmanItem {
  private String name;
  private List<PostmanEvent> event;
  private PostmanRequest request;
  private List<PostmanResponse> response;
  private List<PostmanItem> item;
  private ProtocolProfileBehavior protocolProfileBehavior;

  @Getter
  @Setter
  public class ProtocolProfileBehavior {
    private Boolean followRedirects = true;
  }
}
