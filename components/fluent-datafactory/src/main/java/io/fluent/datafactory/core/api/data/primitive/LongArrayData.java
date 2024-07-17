package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;

@AutoService(IData.class)
public class LongArrayData implements IData<long[]> {

  @Override
  public long[] build(IDataFactoryContext context, Class<long[]> aClass) {
    int size = InnerDataUtil.randomSize();
    long[] array = new long[size];
    for (int i = 0; i < size; i++) {
      array[i] = DataFactoryDataUtil.build(long.class);
    }
    return array;
  }
}
