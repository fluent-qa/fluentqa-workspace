package io.fluent.clients.factory;

import io.fluent.clients.base.HttpClientOption;
import io.fluent.clients.base.HttpException;
import io.fluent.clients.base.HttpRequestModel;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * 1. setup processor
 * 2. send request model
 * 3. get response then handle response
 */
public class HttpClientProcessor {

  private HttpClientOption httpClientConfig;
  private OkHttpClient client;

  public void init() {
    HttpClientFactory factory = new HttpClientFactory();
    HttpClientOption config = new HttpClientOption();
    client = factory.okHttpClient(config);
  }

  public Response invoke(HttpRequestModel httpRequestModel) {

    Response response;
    try {
      response = client.newCall(httpRequestModel.toOkHttRequest()).execute();
      assert response.body() != null;
      System.out.println(response.body().string());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return response;
  }
  //TODO: implement async invoke
  public Response asyncInvoke(HttpRequestModel httpRequestModel) {

    throw new RuntimeException("Not implemented");
  }
}
