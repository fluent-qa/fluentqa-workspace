package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import java.util.concurrent.ThreadLocalRandom;

@AutoService(IData.class)
public class CharData implements IData<Character> {

  /** 限制 */
  private static final int LIMIT = 65535;

  @Override
  public Character build(IDataFactoryContext context, Class<Character> booleanClass) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    final int index = random.nextInt(LIMIT);
    return (char) index;
  }
}
