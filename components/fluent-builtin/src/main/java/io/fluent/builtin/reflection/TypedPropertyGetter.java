package io.fluent.builtin.reflection;

@FunctionalInterface
public interface TypedPropertyGetter<T, V> {
	V get(T bean);
}
