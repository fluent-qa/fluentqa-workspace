package io.fluent.testlibs.datafactory.supplier.converters;

import static cn.hutool.core.util.NumberUtil.parseNumber;
import static java.lang.String.format;

import io.vavr.control.Try;
import java.lang.reflect.Type;

public class DoubleConverter extends DefaultConverter<Double> {
  @Override
  public Double convert(final String value) {
    return Try.of(() -> parseNumber(value))
        .map(Number::doubleValue)
        .getOrElseThrow(
            ex -> new IllegalArgumentException(format("Cannot parse %s to double", value), ex));
  }

  @Override
  public Type getType() {
    return Double.TYPE;
  }
}
