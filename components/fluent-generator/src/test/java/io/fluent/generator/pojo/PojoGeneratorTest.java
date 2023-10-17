package io.fluent.generator.pojo;

import org.junit.jupiter.api.Test;

import java.io.IOException;


class PojoGeneratorTest {
    PojoGenerator generator = new PojoGenerator();
    @Test
    public void testGenerate() throws IOException {
        generator.generate("github-repo.json","io.fluent","GithubRepository","models");
    }
}