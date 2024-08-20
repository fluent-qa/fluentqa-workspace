package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;

@AutoService(IData.class)
public class ByteArrayData implements IData<byte[]> {

  @Override
  public byte[] build(IDataFactoryContext context, Class<byte[]> aClass) {
    int size = InnerDataUtil.randomSize();
    byte[] array = new byte[size];
    for (int i = 0; i < size; i++) {
      array[i] = DataFactoryDataUtil.build(byte.class);
    }
    return array;
  }
}
