package io.fluent.md.parser.awesome;

import io.fluent.md.parser.FieldParseConfig;
import lombok.Data;

@Data
public class AwesomeListParserConfig {
  private FieldParseConfig<String> category;
  private FieldParseConfig<String> name;
  private FieldParseConfig<String> url;
  private FieldParseConfig<String> desc;
  private FieldParseConfig<Object> additional;
}
