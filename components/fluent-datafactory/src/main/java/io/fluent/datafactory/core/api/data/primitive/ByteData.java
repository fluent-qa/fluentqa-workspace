package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;

@AutoService(IData.class)
public class ByteData extends AbstractNumberData implements IData<Byte> {

    @Override
    public Byte build(IDataFactoryContext context, Class<Byte> booleanClass) {
        String string = super.contactInt(context);
        return Byte.valueOf(string);
    }

    @Override
    protected int getMin() {
        return Byte.MIN_VALUE;
    }

    @Override
    protected int getMax() {
        return Byte.MAX_VALUE;
    }
}
