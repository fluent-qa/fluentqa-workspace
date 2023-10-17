package io.fluent.clients.base;

import lombok.Data;

import java.util.Map;

@Data
public class HttpResponseModel {
  private String url;
  private Map<String,String> headers;
  private String method;
  private Object body;
  private int statusCode;
}
