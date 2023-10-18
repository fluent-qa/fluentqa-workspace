package io.fluent.datafactory.core.api.data.util;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;

import java.util.Currency;
import java.util.Locale;


@AutoService(IData.class)
public class CurrencyData implements IData<Currency> {
    @Override
    public Currency build(IDataFactoryContext context, Class<Currency> dateClass) {
        return Currency.getInstance(Locale.CHINA);
    }
}
