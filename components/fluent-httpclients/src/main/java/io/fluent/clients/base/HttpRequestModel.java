package io.fluent.clients.base;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Data
public class HttpRequestModel {
  private String baseUrl;
  private String urlPath;
  private Map<String, String> pathParam = new HashMap<>();
  private Map<String, String> queryParam = new HashMap<>();
  private Map<String, String> headers;
  private MethodEnum method;
  private Object requestBody;
  private Object file;

  public String getRequestPath() {
    StringBuilder path = new StringBuilder(urlPath);
    if (!path.toString().endsWith("/")) {
      path.append("/");
    }
    for (Map.Entry<String, String> entry : pathParam.entrySet()) {
      var pathSegment = entry.getKey() + "/" + entry.getValue() + "/";
      path.append(pathSegment);
    }
    path.append("?");
    for (Map.Entry<String, String> entry : queryParam.entrySet()) {
      var querySegment = entry.getKey() + "=" + entry.getValue() + "&";
      path.append(querySegment);
    }
    return path.toString();
  }

  public HttpRequestModel addPathParams(String key, String value) {
    this.pathParam.put(key, value);
    return this;
  }

  public HttpRequestModel addQueryParams(String key, String value) {
    this.queryParam.put(key, value);
    return this;
  }

  public HttpRequestModel addHeader(String key, String value) {
    this.headers.put(key, value);
    return this;
  }

  public  Request toOkHttRequest(){
    //TODO: How to handler FILE
    Request.Builder requestBuilder = new Request.Builder().url(this.getRequestPath())
      .headers(Headers.of(this.headers));
    if (requestBody!=null){
       RequestBody body = RequestBody.create(JSONUtil.toJsonStr(requestBody), MediaType.get("application/json"));
       requestBuilder.method(method.toString(),body);
    }
    return requestBuilder.build();
  }
}
