package io.fluent.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;

public class SwaggerParser {
  private OpenAPIV3Parser parser = new OpenAPIV3Parser();

  public OpenAPI toCollection(String swaggerUrl) {

    return parser.read(swaggerUrl);
  }
}
