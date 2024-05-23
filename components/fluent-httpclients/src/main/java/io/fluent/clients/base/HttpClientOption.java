package io.fluent.clients.base;

import java.net.Proxy;
import lombok.Data;
import okhttp3.logging.HttpLoggingInterceptor;

@Data
public class HttpClientOption extends HttpRequestModel {

  /** 日志等级 */
  private HttpLoggingInterceptor.Level loggLevel = HttpLoggingInterceptor.Level.BODY;
  /** 读取超时时间，秒 */
  private long readTimeout = 30;
  /** 链接超时时间 */
  private long connectTimeout = 30;

  private boolean followRedirects = false;
  /** 最大的连接数 */
  private int maxIdleConnections = 5;
  /** 最大的kepAlive 时间 秒 */
  private long keepAliveDuration = 5;
  //    private String userAgent = "OKHTTP";
  private String referer = "";
  /** 是否支持cookie */
  private boolean cookie = false;

  private ProxyConfig proxy;
  private boolean useProxy = false;

  @Data
  public static class ProxyConfig {

    private Proxy.Type type = Proxy.Type.HTTP;
    private String host;
    private Integer port = 80;
    private String userName;
    private String password;
  }

  public static HttpClientOption getDefaultConfig() {
    return new HttpClientOption();
  }

  public HttpClientOption defineProxy(ProxyConfig proxyConfig) {
    this.setProxy(proxyConfig);
    this.useProxy = true;
    return this;
  }
}
