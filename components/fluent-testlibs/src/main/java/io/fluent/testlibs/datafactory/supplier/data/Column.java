package io.fluent.testlibs.datafactory.supplier.data;

import io.fluent.testlibs.datafactory.supplier.converters.StringConverter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
  String name();

  String format() default "";

  Class<?> converter() default StringConverter.class;
}
