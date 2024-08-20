package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;

/**
 * @author binbin.hou date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class IntegerData extends AbstractNumberData implements IData<Integer> {

  @Override
  public Integer build(IDataFactoryContext context, Class<Integer> booleanClass) {
    final String string = super.contactInt(context);
    return Integer.valueOf(string);
  }
}
