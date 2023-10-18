package io.fluent.datafactory.core;


import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.context.DefaultDataContext;
import io.fluent.datafactory.core.support.factory.DataFactoryMapping;

import java.util.Objects;

public class DataFactoryData<T> implements IData<T> {

    @Override
    @SuppressWarnings("all")
    public T build(IDataFactoryContext context, Class<T> tClass) {
        if(Objects.isNull(context)) {
            context = new DefaultDataContext();
        }
        IData data = DataFactoryMapping.getData(tClass);
        return (T) data.build(context, tClass);
    }

}
