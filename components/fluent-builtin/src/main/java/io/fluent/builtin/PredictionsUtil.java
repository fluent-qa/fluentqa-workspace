package io.fluent.builtin;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
public class PredictionsUtil {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return seen.add(keyExtractor.apply(t));
            }
        };
    }
}
