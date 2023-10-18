package io.fluent.datafactory.core.api.data.time;


import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;


import java.time.LocalDate;
import java.time.Year;


@AutoService(IData.class)
public class YearData implements IData<Year> {
    @Override
    public Year build(IDataFactoryContext context, Class<Year> localDateClass) {
        return Year.now();
    }
}
