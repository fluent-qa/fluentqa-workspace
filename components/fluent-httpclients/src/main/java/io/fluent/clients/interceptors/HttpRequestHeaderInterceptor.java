package io.fluent.clients.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class HttpRequestHeaderInterceptor implements Interceptor {



  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Request request = chain.request();
    //TODO: add interceptor
    return null;
  }
}
