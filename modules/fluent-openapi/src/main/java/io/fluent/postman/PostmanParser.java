package io.fluent.postman;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import io.fluent.postman.model.PostmanCollection;
import java.io.File;
import java.nio.charset.Charset;

public class PostmanParser {

  public PostmanCollection toPostmanCollection(String jsonString) {
    return JSONUtil.toBean(jsonString, PostmanCollection.class, true);
  }

  public PostmanCollection toPostmanCollectionFromFile(String filePath) {
    JSON json = JSONUtil.readJSON(new File(filePath), Charset.defaultCharset());
    return JSONUtil.toBean(json, PostmanCollection.class, true);
  }

  public static PostmanParser create() {
    return new PostmanParser();
  }
}
