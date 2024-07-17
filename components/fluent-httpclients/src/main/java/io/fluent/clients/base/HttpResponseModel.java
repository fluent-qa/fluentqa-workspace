package io.fluent.clients.base;

import java.util.Map;
import lombok.Data;

@Data
public class HttpResponseModel {
  private String url;
  private Map<String, String> headers;
  private String method;
  private Object body;
  private int statusCode;
}
