package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;

@AutoService(IData.class)
public class DoubleData extends AbstractNumberData implements IData<Double> {

  @Override
  public Double build(IDataFactoryContext context, Class<Double> booleanClass) {
    final String string = super.contactIntDecimal(context);
    return Double.valueOf(string);
  }
}
