package io.fluent.builtin.meta;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TargetType<T> {

    public Type getType() {

        Type t = getClass().getGenericSuperclass();
        if (!(t instanceof ParameterizedType)) {
            throw new IllegalStateException("Incorrect use of TypeToken: " + t);
        }
        ParameterizedType pt = (ParameterizedType) t;
        Type[] typeArgs = pt.getActualTypeArguments();
        if (typeArgs.length > 0) {
            return typeArgs[0];
        }
        throw new IllegalStateException("Incorrect use of TypeToken: " + t);
    }

    @SuppressWarnings("unchecked")
    public Class<T> getClassType() {

        Type type = getType();
        if (type instanceof ParameterizedType) {
            return (Class<T>) ((ParameterizedType) type).getRawType();
        } else {
            return (Class<T>) type;
        }
    }
}
