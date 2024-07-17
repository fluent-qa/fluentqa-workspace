package io.fluent.testlibs.datafactory.supplier.converters;

import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;

public class LocalDateTimeConverter extends DefaultConverter<LocalDateTime> {
  public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

  @Override
  public LocalDateTime convert(final String value) {
    return convert(value, DEFAULT_FORMAT);
  }

  @Override
  public LocalDateTime convert(final String value, final String format) {
    return parse(
        value, ofPattern(ofNullable(format).filter(f -> !f.isEmpty()).orElse(DEFAULT_FORMAT)));
  }
}
