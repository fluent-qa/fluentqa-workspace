package io.fluent.testlibs.datafactory.supplier.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.*;

/**
 * A listener which allows intercepting IAnnotationTransformer events. Should be implemented on
 * client side, and linked via SPI.
 */
public interface IAnnotationTransformerInterceptor {

  default <T> void transform(
      final ITestAnnotation annotation,
      final Class<T> testClass,
      final Constructor<T> testConstructor,
      final Method testMethod) {
    // not implemented
  }

  default void transform(final IFactoryAnnotation annotation, final Method testMethod) {
    // not implemented
  }

  default <T> void transform(
      final IConfigurationAnnotation annotation,
      final Class<T> testClass,
      final Constructor<T> testConstructor,
      final Method testMethod) {
    // not implemented
  }

  default void transform(final IDataProviderAnnotation annotation, final Method method) {
    // not implemented
  }

  default <T> void transform(final IListenersAnnotation annotation, final Class<T> testClass) {
    // not implemented
  }
}
