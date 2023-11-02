# OpenAPI Diff

- Maven POM setting
```xml
 <dependency>
  <groupId>org.openapitools.openapidiff</groupId>
  <artifactId>openapi-diff-core</artifactId>
  <version>${openapi-diff-version}</version>
</dependency>
```

- How to Get OpenAPI differences
    * API Difference
    * API Difference in HTMLRender
    * API Difference in JSONRender
    * API Difference in Markdown Render
```java
  String originPetStore = "./petstore_v3.yml";
        String newPetStore = "./petstore_v2.json";

        ChangedOpenApi diff = OpenApiCompare.fromLocations(originPetStore,newPetStore);
        System.out.println(diff);

        //write to html
        String html = new HtmlRender("Changelog",
                "http://deepoove.com/swagger-diff/stylesheets/demo.css")
                .render(diff);
        FileUtils.writeStringToFile(new File("apiDifference.html"),html,
                Charset.defaultCharset());
        String markdownRender = new MarkdownRender().render(diff);
        FileUtils.writeStringToFile(new File("apiDifference.md"),markdownRender,
                Charset.defaultCharset());

        String jsonDiff = new JsonRender().render(diff);
        FileUtils.writeStringToFile(new File("apiDifference.json"),jsonDiff,
                Charset.defaultCharset());
```