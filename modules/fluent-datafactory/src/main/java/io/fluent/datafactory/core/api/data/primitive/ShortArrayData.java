package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;

@AutoService(IData.class)
public class ShortArrayData implements IData<short[]> {

  @Override
  public short[] build(IDataFactoryContext context, Class<short[]> aClass) {
    int size = InnerDataUtil.randomSize();
    short[] array = new short[size];
    for (int i = 0; i < size; i++) {
      array[i] = DataFactoryDataUtil.build(short.class);
    }
    return array;
  }
}
