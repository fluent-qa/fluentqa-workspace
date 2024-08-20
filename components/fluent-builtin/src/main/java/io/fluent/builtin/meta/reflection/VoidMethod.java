package io.fluent.builtin.meta.reflection;

@FunctionalInterface
public interface VoidMethod<T> {
  void invoke(T bean) throws Exception;
}
