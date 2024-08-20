package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;

/**
 * int 数据实现
 *
 * @author binbin.hou date 2019/2/26
 * @since 0.0.7
 */
@AutoService(IData.class)
public class IntegerArrayData implements IData<int[]> {

  @Override
  public int[] build(IDataFactoryContext context, Class<int[]> aClass) {
    int size = InnerDataUtil.randomSize();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = DataFactoryDataUtil.build(int.class);
    }
    return array;
  }
}
