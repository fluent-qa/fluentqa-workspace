package io.fluent.datafactory.core.api.data.time;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import java.time.LocalDate;

@AutoService(IData.class)
public class LocalDateData implements IData<LocalDate> {
  @Override
  public LocalDate build(IDataFactoryContext context, Class<LocalDate> localDateClass) {
    return LocalDate.now();
  }
}
