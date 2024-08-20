package io.fluent.builtin.annotation;

import java.lang.annotation.*;

/***
 * Not Thread Safe Notification
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotThreadSafe {}
