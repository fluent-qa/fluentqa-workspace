package io.fluent.testlibs.datafactory.supplier.converters;

public class StringConverter extends DefaultConverter<String> {
  @Override
  public String convert(final String value) {
    return value;
  }
}
