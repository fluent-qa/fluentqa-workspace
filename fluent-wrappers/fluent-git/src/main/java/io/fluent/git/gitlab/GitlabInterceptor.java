package io.fluent.git.gitlab;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class GitlabInterceptor implements Interceptor {

  private String token;

  public GitlabInterceptor(String token) {
    this.token = token;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Request authenticatedRequest =
        request
            .newBuilder()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .header("PRIVATE-TOKEN", token)
            .build();
    return chain.proceed(authenticatedRequest);
  }
}
