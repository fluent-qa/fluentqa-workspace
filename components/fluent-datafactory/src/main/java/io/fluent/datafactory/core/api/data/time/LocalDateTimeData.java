package io.fluent.datafactory.core.api.data.time;


import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;


import java.time.LocalDateTime;


@AutoService(IData.class)
public class LocalDateTimeData implements IData<LocalDateTime> {
    @Override
    public LocalDateTime build(IDataFactoryContext context, Class<LocalDateTime> localDateClass) {
        return LocalDateTime.now();
    }
}
