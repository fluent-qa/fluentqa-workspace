//package io.fluentqa.clients.factory;
//
//import io.fluentqa.builtin.jsons.JSONUtils;
//import io.fluentqa.clients.base.HttpClientOption;
//import io.fluentqa.clients.base.HttpRequestModel;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class HttpClientFactoryTest {
//  HttpClientFactory factory = new HttpClientFactory();
//  HttpClientOption config = new HttpClientOption();
//  OkHttpClient client = factory.okHttpClient(config);
//
//  @Test
//  void test_OkHttpClient() {
//    OkHttpClient client = factory.okHttpClient(config);
//    assertNotNull(client);
//  }
//
//  @Test
//  void test_OkHttpClient_get() {
//    Request request = new Request.Builder()
//      .url("https://www.baidu.com").build();
//    callApi(request);
//  }
//
//  String tokenRespones = "{\"user_info\":{\"id\":1,\"name\":\"prest\",\"username\":\"prest\"," +
//    "\"metadata\":null},\"token\":" +
//    "\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySW5mbyI6eyJpZCI6MSwibWV0YWRhdGEiOm51bGwsIm5hbWUiOiJwcmVzdCIsInVzZXJuYW1lIjoicHJlc3QifSwiZXhwIjoxNjgzNTY2MTMzLCJuYmYiOjE2ODM1NDQ1MzN9.4xSD5TiEnauLrLwLRbEHxwK6lduXIjvwijiPLXvYdYo\"}\n";
//
//  @Test
//  void testPrestdGetSchema() {
//    Request request = new Request.Builder().url("http://127.0.0.1:3000/auth")
//      .post(RequestBody.create("{\"username\": \"prest\", \"password\": \"prest\"}"
//        .getBytes(StandardCharsets.UTF_8))).build();
//    Response response = null;
//    callApi(request);
//  }
//
//  private void callApi(Request request) {
//    Response response;
//    try {
//      response = client.newCall(request).execute();
//      System.out.println(response.body().string());
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
//  }
//
//  String baseUrl = "http://127.0.0.1:3000";
//  //Authorization: Bearer {TOKEN}
//  String auth="auth";
//  String show_url="/show/{DATABASE}/{SCHEMA}/{TABLE}";
//
//  /**
//   * Endpoints	Description
//   * /_health	Health check endpoint
//   * /databases	List all databases
//   * /schemas	List all schemas
//   * /tables	List all tables
//   * /show/{DATABASE}/{SCHEMA}/{TABLE}	Lists table structure - all fields contained in the table
//   * /{DATABASE}/{SCHEMA}	Lists table tables - find by schema
//   * /{DATABASE}/{SCHEMA}/{TABLE}	List all rows, find by database, schema and table
//   * /{DATABASE}/{SCHEMA}/{VIEW}	List all rows, find by database, schema and view
//   *
//   * POST:
//   * /{DATABASE}/{SCHEMA}/{TABLE}
//   * {
//   *     "FIELD1": "string value",
//   *     "FIELD2": 1234567890
//   * }
//   *
//   * PATCH/PUT:
//   * /{DATABASE}/{SCHEMA}/{TABLE}?{FIELD NAME}={VALUE}
//   * {
//   *     "FIELD1": "string value",
//   *     "FIELD2": 1234567890,
//   *     "ARRAYFIELD": ["value 1","value 2"]
//   * }
//   * DELETE:
//   * /{DATABASE}/{SCHEMA}/{TABLE}?{FIELD NAME}={VALUE}
//   */
//  @Test
//  void testprestdGetDatabases() {
//    prestdQueryService("databases");
//    prestdQueryService("schemas");
//    prestdQueryService("tables");
//  }
//
//  void prestdQueryService(String serviceName){
//    String token = JSONUtils.parse(tokenRespones).getByPath("token").toString();
//    Request request = new Request.Builder().url("http://127.0.0.1:3000/"+serviceName)
//      .addHeader("Authorization", "Bearer %s".formatted(token))
//      .get().build();
//    callApi(request);
//  }
//  //supabase postrest invocation
//  @Test
//  void querySupabaseService(){
//    String baseUrl = "http://localhost:54321/rest/v1/users";
//    String serviceKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZS1kZW1vIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImV4cCI6MTk4MzgxMjk5Nn0.EGIM96RAZx35lJzdJsyH-qQwv8Hdp7fsn3W0YpN81IU";
//    String apiKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZS1kZW1vIiwicm9sZSI6ImFub24iLCJleHAiOjE5ODM4MTI5OTZ9.CRXP1A7WOeoJeXxjNni43kdQwgnWNReilDMblYTn_I0";
//    Request request = new Request.Builder().url(baseUrl)
//      .addHeader("Authorization", "Bearer %s".formatted(serviceKey))
//      .addHeader("apikey", apiKey)
//      .get().build();
//    callApi(request);
//  }
//
//  @Test
//  void functionCall(){
//    String baseUrl = "http://localhost:54321/rest/v1/rpc/get_key_by_email?in_email=test_1@163.com";
//    String serviceKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZS1kZW1vIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImV4cCI6MTk4MzgxMjk5Nn0.EGIM96RAZx35lJzdJsyH-qQwv8Hdp7fsn3W0YpN81IU";
//    String apiKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZS1kZW1vIiwicm9sZSI6ImFub24iLCJleHAiOjE5ODM4MTI5OTZ9.CRXP1A7WOeoJeXxjNni43kdQwgnWNReilDMblYTn_I0";
//    Request request = new Request.Builder().url(baseUrl)
//      .addHeader("Authorization", "Bearer %s".formatted(serviceKey))
//      .addHeader("apikey", apiKey)
//      .get().build();
//    callApi(request);
//  }
//
//  @Test
//  void testHttpProcessor(){
//    HttpRequestModel request = new HttpRequestModel();
//    HttpClientProcessor processor = new HttpClientProcessor();
//    processor.init();
//    processor.invoke(request);
//
//  }
//}