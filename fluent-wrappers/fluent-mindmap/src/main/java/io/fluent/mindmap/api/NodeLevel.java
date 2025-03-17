package io.fluent.mindmap.api;

import java.lang.annotation.*;

/** */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
public @interface NodeLevel {
  int value();
}
