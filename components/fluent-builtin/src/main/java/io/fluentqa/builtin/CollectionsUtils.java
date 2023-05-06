package io.fluentqa.builtin;


import cn.hutool.core.collection.CollectionUtil;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 集合操作工具类
 */
public class CollectionsUtils extends CollectionUtil {

    private CollectionsUtils() {
    }

    /**
     * 根据条件过滤数组元素
     *
     * @param source
     * @param condition
     * @param <T>
     * @return 如果全部过滤完则返回null
     */
    public static <T> T filterToOne(T[] source, Predicate<T> condition) {

        List<T> result = filter(source, condition);
        if (result != null && result.size() >= 1) return result.get(0);
        return null;
    }

    /**
     * filter source by condition
     *
     * @param source
     * @param condition
     * @param <T>
     * @return {@List} all the matched result
     */
    public static <T> List<T> filter(T[] source, Predicate<T> condition) {

        return Stream.of(source).filter(condition).collect(Collectors.toList());
    }


    /**
     * 根据条件过滤集合元素
     *
     * @param source
     * @param conditions
     * @param <T>
     * @return 如果全部过滤完则返回null
     */
    public static <T> T filterByOrConditions(Collection<T> source, Predicate<T>... conditions) {

        for (T s : source) {
            for (Predicate<T> condition : conditions) {
                if (condition.test(s)) return s;
            }
        }
        return null;
    }


    /**
     * 根据条件过滤集合元素
     *
     * @param source
     * @param condition
     * @param <T>
     * @return 如果全部过滤完则返回空ArrayList
     */
    public static <T> List<T> filter(Collection<T> source, Predicate<T> condition) {
        return source.stream().filter(condition).collect(Collectors.toList());
    }


    /**
     * 根据条件过滤集合元素
     *
     * @param source
     * @param condition
     * @param <T>
     * @return 如果全部过滤完则返回null
     */
    public static <T> T filterToOne(Collection<T> source, Predicate<T> condition) {
        List<T> result = source.stream().filter(condition).collect(Collectors.toList());
        if (result == null && result.size() == 0) return null;
        return source.stream().filter(condition).collect(Collectors.toList()).get(0);
    }

    /**
     * return if one array contains another array
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> boolean arrayContains(T[] source, T target) {
        for (T t : source) {
            if (t.equals(target)) return true;
        }
        return false;
    }


    public static <T> T lastElementOf(T[] objects) {
        if (objects == null || objects.length == 0) return null;
        int length = objects.length;
        return objects[length - 1];
    }

}
