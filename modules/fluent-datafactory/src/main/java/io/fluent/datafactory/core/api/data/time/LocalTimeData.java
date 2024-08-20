package io.fluent.datafactory.core.api.data.time;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import java.time.LocalTime;

@AutoService(IData.class)
public class LocalTimeData implements IData<LocalTime> {
  @Override
  public LocalTime build(IDataFactoryContext context, Class<LocalTime> localDateClass) {
    return LocalTime.now();
  }
}
