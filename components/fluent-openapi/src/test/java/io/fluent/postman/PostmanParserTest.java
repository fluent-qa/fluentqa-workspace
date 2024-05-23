package io.fluent.postman;

import cn.hutool.core.io.FileUtil;
import io.fluent.postman.model.PostmanCollection;
import java.nio.charset.Charset;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostmanParserTest {
  PostmanParser parser = new PostmanParser();

  @Test
  void toPostmanCollectionFromFile() {
    String jsonString = FileUtil.readString("openproject-postman.json", Charset.defaultCharset());
    PostmanCollection pc = parser.toPostmanCollection(jsonString);
    Assertions.assertThat(pc.getItem()).isNotNull();
  }
}
