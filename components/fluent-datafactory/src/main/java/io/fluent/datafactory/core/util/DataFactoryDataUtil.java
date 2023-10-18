package io.fluent.datafactory.core.util;


import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.DataFactoryData;

public final class DataFactoryDataUtil {

    private DataFactoryDataUtil(){}

    /**
     * 构建结果
     * @param clazz 类型
     * @return 构建结果
     * @param <T> 泛型
     */
    public static <T> T build(final Class<T> clazz) {
        return build(null, clazz);
    }

    /**
     * 构建结果
     * @param context 执行上下文
     * @param clazz 类型
     * @return 构建结果
     * @param <T> 泛型
     */
    @SuppressWarnings("all")
    public static <T> T build(final IDataFactoryContext context, final Class<T> clazz) {
        IData data = new DataFactoryData();
        return (T) data.build(context, clazz);
    }

}
