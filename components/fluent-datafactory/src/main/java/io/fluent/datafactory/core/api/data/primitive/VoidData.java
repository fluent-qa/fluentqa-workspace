package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;


@AutoService(IData.class)
public class VoidData implements IData<Void> {

    @Override
    public Void build(IDataFactoryContext context, Class<Void> booleanClass) {
        return null;
    }

}
