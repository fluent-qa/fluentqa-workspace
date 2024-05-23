package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;

@AutoService(IData.class)
public class CharArrayData implements IData<char[]> {

  @Override
  public char[] build(IDataFactoryContext context, Class<char[]> aClass) {
    int size = InnerDataUtil.randomSize();
    char[] array = new char[size];
    for (int i = 0; i < size; i++) {
      array[i] = DataFactoryDataUtil.build(char.class);
    }
    return array;
  }
}
