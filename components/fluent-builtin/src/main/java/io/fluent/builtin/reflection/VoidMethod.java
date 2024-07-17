package io.fluent.builtin.reflection;

@FunctionalInterface
public interface VoidMethod<T> {
  void invoke(T bean) throws Exception;
}
