package io.fluent.md.parser;

import java.util.function.Function;

import lombok.Data;
import org.jsoup.nodes.Element;

@Data
public class FieldParseConfig<T> {
  private String key;
  private Function<Element, T> extractFunc;
}
