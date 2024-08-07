package io.fluent.datafactory.core.api.data.aggregate;

import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.exception.DataFactoryRuntimeException;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * map 集合的实现
 *
 * @author binbin.hou date 2019/2/26
 * @since 0.0.1
 */
public class IterableData<T> implements IData<Iterable<T>> {

  @Override
  @SuppressWarnings("all")
  public Iterable<T> build(IDataFactoryContext context, Class<Iterable<T>> iterableClass) {
    // 直接存放线性表
    Iterable<T> result = newInstance(iterableClass);
    if (CollectionUtil.isEmpty(context.getGenericList())) {
      return result;
    }

    // 获取元素类型
    final Class<T> itemClass = context.getGenericList().get(0);
    // 新增元素
    final int size = InnerDataUtil.randomSize();
    Collection<T> collection = (Collection<T>) result;
    for (int i = 0; i < size; i++) {
      final T object = DataFactoryDataUtil.build(context, itemClass);
      collection.add(object);
    }

    return result;
  }

  /**
   * 创建对应的实例
   *
   * @param iterableClass 类
   * @return 结果
   */
  private Iterable<T> newInstance(final Class<Iterable<T>> iterableClass) {
    try {
      return ClassUtil.newInstance(iterableClass);
    } catch (Exception e) {
      if (List.class.isAssignableFrom(iterableClass)) {
        return new ArrayList<>();
      }
      if (Set.class.isAssignableFrom(iterableClass)) {
        return new HashSet<>();
      }
      if (Queue.class.isAssignableFrom(iterableClass)) {
        return new ArrayDeque<>();
      }
      throw new DataFactoryRuntimeException(e);
    }
  }
}
