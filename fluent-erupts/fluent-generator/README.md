# Fluent Code Generator 

## pojo Generator: Generate POJO from JSON file

```java
class PojoGeneratorTest {
    PojoGenerator generator = new PojoGenerator();
    @Test
    public void testGenerate() throws IOException {
        generator.generate("github-repo.json","io.fluent","GithubRepository","models");
    }
}
```

## Code Generator

- Data Source
- Table Data
- Field Data
- Generate Type/Template MAPPING
- Generate Code


## API Generator

Based on crabc

