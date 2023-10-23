## Postman 解析

一下代码可以进行postman解析: 

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

文件读取后,会转化为PostmanCollection类.后续需要如何处理直接通过Postman转换进行.