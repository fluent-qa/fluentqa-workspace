package io.fluent.testlibs.datafactory.supplier.converters;

import static java.lang.Integer.parseInt;

import java.lang.reflect.Type;

public class IntegerConverter extends DefaultConverter<Integer> {
  @Override
  public Integer convert(final String value) {
    return parseInt(value);
  }

  @Override
  public Type getType() {
    return Integer.TYPE;
  }
}
