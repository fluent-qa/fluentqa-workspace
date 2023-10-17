package io.fluent.clients.rest;
import io.fluent.clients.base.HttpClientOption;
import io.fluent.clients.base.HttpRequestModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//https://github.com/rest-assured/rest-assured/wiki/Usage
public class RestAssuredClient {

  private RequestSpecification reqClient;

  public RestAssuredClient create(HttpClientOption option){
    reqClient = RestAssured.given().baseUri(option.getBaseUrl()).
          headers(option.getHeaders());
        return this;
  }

  public Response invoke(HttpRequestModel request){
    reqClient.headers(request.getHeaders());
      if(request.getMethod().toString().equalsIgnoreCase("GET")) {
        return reqClient.get(request.getRequestPath());
      }
    if(request.getMethod().toString().equalsIgnoreCase("POST")) {
      return reqClient.post(request.getRequestPath(),request.getRequestBody());
    }
    if(request.getMethod().toString().equalsIgnoreCase("PUT")) {
      return reqClient.put(request.getRequestPath(),request.getRequestBody());
    }
    if(request.getMethod().toString().equalsIgnoreCase("DELETE")) {
      return reqClient.delete(request.getRequestPath());
    }
    throw new RuntimeException("Not Support Method Right now: "+request.getMethod());
  }

}
