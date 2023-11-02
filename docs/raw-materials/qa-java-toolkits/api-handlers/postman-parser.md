## Postman Parser

- [fluentqa-openapi](fluent-components%2Ffluentqa-apispec%2Ffluentqa-openapi) Postman parser
```java
public class PostmanParserTest {
  PostmanParser parser = new PostmanParser();

  @Test
  void toPostmanCollectionFromFile() {
    String jsonString =  FileUtil.readString("openproject-postman.json", Charset.defaultCharset());
    PostmanCollection pc =  parser.toPostmanCollection(jsonString);
    Assertions.assertThat(pc.getItem()).isNotNull();
    }
}
```