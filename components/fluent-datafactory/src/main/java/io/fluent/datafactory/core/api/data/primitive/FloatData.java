package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;


@AutoService(IData.class)
public class FloatData extends AbstractNumberData implements IData<Float> {

    @Override
    public Float build(IDataFactoryContext context, Class<Float> booleanClass) {
        final String string = super.contactIntDecimal(context);
        return Float.valueOf(string);
    }

}
