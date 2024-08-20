package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import java.util.concurrent.ThreadLocalRandom;

@AutoService(IData.class)
public class BoolData implements IData<Boolean> {

  @Override
  public Boolean build(IDataFactoryContext context, Class<Boolean> booleanClass) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    return random.nextBoolean();
  }
}
