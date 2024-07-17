package io.fluent.swagger.model;

import cn.hutool.json.JSONObject;
import java.util.List;
import lombok.Data;

@Data
public class SwaggerApi {
  private String swagger;
  private SwaggerInfo info;
  private String host;
  private String basePath;
  private List<String> schemes;
  private List<SwaggerTag> tags;
  private JSONObject paths;
  private JSONObject definitions;
}
