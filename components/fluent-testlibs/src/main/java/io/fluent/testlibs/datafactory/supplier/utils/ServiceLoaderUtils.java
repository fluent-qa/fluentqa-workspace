package io.fluent.testlibs.datafactory.supplier.utils;

import static java.util.Collections.emptyList;

import io.vavr.control.Try;
import java.util.List;
import java.util.ServiceLoader;
import lombok.experimental.UtilityClass;
import one.util.streamex.StreamEx;

/** SPI management internals for dynamic listeners' implementation loading. */
@UtilityClass
public class ServiceLoaderUtils {

  public static <T> List<T> load(final Class<T> type, final ClassLoader classLoader) {
    return Try.of(() -> StreamEx.of(ServiceLoader.load(type, classLoader).iterator()).toList())
        .getOrElseGet(ex -> emptyList());
  }
}
