package io.fluentqa.generator.pojo;

import io.fluentqa.generator.service.JsonToPojoGenerateService;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PojoGeneratorTest {
  JsonToPojoGenerateService generator = new JsonToPojoGenerateService();

  @Test
  public void testGenerate() throws IOException {
    generator.generate("github-repo.json", "io.fluent", "GithubRepository", "models");
  }
}
