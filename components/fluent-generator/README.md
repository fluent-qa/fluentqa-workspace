# Fluent Code Generator 

## pojo Generator

```java
class PojoGeneratorTest {
    PojoGenerator generator = new PojoGenerator();
    @Test
    public void testGenerate() throws IOException {
        generator.generate("github-repo.json","io.fluent","GithubRepository","models");
    }
}
```

