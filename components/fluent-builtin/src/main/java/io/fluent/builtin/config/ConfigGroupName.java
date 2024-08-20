package io.fluent.builtin.config;

import java.lang.annotation.*;

/**
 * configuration group tag
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigGroupName {
  String name() default "";
}
