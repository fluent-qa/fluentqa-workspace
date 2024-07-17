package io.fluent.datafactory.api.core;

public interface IData<T> {

  /**
   * 构建数据
   *
   * @param context 运行上下文
   * @param tClass 对象类型
   * @return 构建结果
   */
  T build(final IDataFactoryContext context, final Class<T> tClass);
}
