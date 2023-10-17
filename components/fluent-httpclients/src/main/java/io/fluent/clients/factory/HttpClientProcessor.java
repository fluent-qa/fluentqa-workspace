package io.fluent.clients.factory;

import io.fluent.clients.base.HttpClientOption;
import io.fluent.clients.base.HttpRequestModel;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;

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
}
