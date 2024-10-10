package io.fluent.clients.factory;

import static java.net.CookiePolicy.ACCEPT_ORIGINAL_SERVER;

import io.fluent.clients.base.HttpClientOption;

import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.Credentials;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

public class HttpClientFactory {

    public OkHttpClient okHttpClient(HttpClientOption httpConfig) {

        ConnectionPool connectionPool =
                new ConnectionPool(
                        httpConfig.getMaxIdleConnections(),
                        httpConfig.getKeepAliveDuration(),
                        TimeUnit.SECONDS);

        OkHttpClient.Builder builder =
                new OkHttpClient.Builder()
                        .connectionPool(connectionPool)
                        // 跳转由自己控制
                        .followRedirects(false)
                        .readTimeout(Duration.ofSeconds(httpConfig.getReadTimeout()))
                        .connectTimeout(Duration.ofSeconds(httpConfig.getReadTimeout()));

        if (httpConfig.isCookie()) {
            CookieManager cookieManager = new CookieManager(null, ACCEPT_ORIGINAL_SERVER);
            builder.cookieJar(new JavaNetCookieJar(cookieManager));
        }
        // proxy
        if (httpConfig.isUseProxy()) {
            builder.proxy(
                    new Proxy(
                            httpConfig.getProxy().getType(),
                            new InetSocketAddress(
                                    httpConfig.getProxy().getHost(), httpConfig.getProxy().getPort())));
            if (StringUtils.isNotBlank(httpConfig.getProxy().getPassword())) {
                builder.proxyAuthenticator(
                        (route, response) -> {
                            // 设置代理服务器账号密码
                            String credential =
                                    Credentials.basic(
                                            httpConfig.getProxy().getUserName(), httpConfig.getProxy().getPassword());
                            return response
                                    .request()
                                    .newBuilder()
                                    .header("Proxy-Authorization", credential)
                                    .build();
                        });
            }
        }
        return builder.build();
    }
}
