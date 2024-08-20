package io.fluent.builtin.meta.reflection;

@FunctionalInterface
public interface TypedPropertyGetter<T, V> {
  V get(T bean);
}
