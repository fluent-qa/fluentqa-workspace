package io.fluent.datafactory.core.api.data.primitive;


import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;


@AutoService(IData.class)
public class BoolArrayData implements IData<boolean[]> {

    @Override
    public boolean[] build(IDataFactoryContext context, Class<boolean[]> aClass) {
        int size = InnerDataUtil.randomSize();
        boolean[] array = new boolean[size];
        for(int i = 0; i < size; i++) {
            array[i] = DataFactoryDataUtil.build(boolean.class);
        }
        return array;
    }

}
