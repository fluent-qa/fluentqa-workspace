package io.fluent.testlibs.datafactory.supplier.converters;

import static java.lang.Boolean.parseBoolean;

import java.lang.reflect.Type;

public class BooleanConverter extends DefaultConverter<Boolean> {
  @Override
  public Boolean convert(final String value) {
    return parseBoolean(value);
  }

  @Override
  public Type getType() {
    return Boolean.TYPE;
  }
}
