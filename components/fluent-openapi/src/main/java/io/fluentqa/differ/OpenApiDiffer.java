package io.fluentqa.differ;

import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.openapitools.openapidiff.core.output.JsonRender;
import org.openapitools.openapidiff.core.output.MarkdownRender;
import org.openapitools.openapidiff.core.output.Render;

public class OpenApiDiffer {

  public String apiDifferenceJsonContent(String oriLocation, String newLocation) {
    ChangedOpenApi diff = OpenApiCompare.fromLocations(oriLocation, newLocation);
    return new JsonRender().render(diff);
  }

  public String apiDifferenceHtmlContent(String oriLocation, String newLocation) {
    ChangedOpenApi diff = OpenApiCompare.fromLocations(oriLocation, newLocation);
    String linkCss = "http://deepoove.com/swagger-diff/stylesheets/demo.css";
    return new HtmlRender("Changelog", linkCss).render(diff);
  }

  public String apiDifferenceMarkDownContent(String oriLocation, String newLocation) {
    ChangedOpenApi diff = OpenApiCompare.fromLocations(oriLocation, newLocation);
    return new MarkdownRender().render(diff);
  }

  public String apiDifferences(String oriLocation, String newLocation, Render render) {
    ChangedOpenApi diff = OpenApiCompare.fromLocations(oriLocation, newLocation);
    return render.render(diff);
  }

}
