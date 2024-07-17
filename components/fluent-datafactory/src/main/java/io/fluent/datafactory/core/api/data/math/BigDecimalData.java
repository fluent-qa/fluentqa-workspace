package io.fluent.datafactory.core.api.data.math;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;
import java.math.BigDecimal;

@AutoService(IData.class)
public class BigDecimalData extends AbstractNumberData implements IData<BigDecimal> {

  @Override
  public BigDecimal build(IDataFactoryContext context, Class<BigDecimal> bigIntegerClass) {
    final String string = super.contactIntDecimal(context);
    return new BigDecimal(string);
  }
}
