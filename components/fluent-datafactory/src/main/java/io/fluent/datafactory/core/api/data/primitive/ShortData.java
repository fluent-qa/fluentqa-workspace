package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;

@AutoService(IData.class)
public class ShortData extends AbstractNumberData implements IData<Short> {

  @Override
  public Short build(IDataFactoryContext context, Class<Short> booleanClass) {
    final String string = super.contactInt(context);
    return Short.valueOf(string);
  }

  @Override
  protected int getMin() {
    return Short.MIN_VALUE;
  }

  @Override
  protected int getMax() {
    return Short.MAX_VALUE;
  }
}
