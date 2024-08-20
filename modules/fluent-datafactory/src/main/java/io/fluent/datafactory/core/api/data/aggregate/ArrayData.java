package io.fluent.datafactory.core.api.data.aggregate;

import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;
import java.lang.reflect.Array;

public class ArrayData<T> implements IData<T[]> {

  @Override
  @SuppressWarnings("all")
  public T[] build(IDataFactoryContext context, Class<T[]> aClass) {
    final Class<T> itemClass = (Class<T>) aClass.getComponentType();
    final int size = InnerDataUtil.randomSize();
    T[] arrays = (T[]) Array.newInstance(itemClass, size);
    T item = DataFactoryDataUtil.build(itemClass);

    for (int i = 0; i < size; i++) {
      Array.set(arrays, i, item);
    }

    return arrays;
  }
}
