package io.fluent.datafactory.core.api.data.aggregate;

import com.github.houbb.heaven.util.util.ArrayUtil;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;


import java.util.concurrent.ThreadLocalRandom;


public class EnumData implements IData<Enum> {

    @Override
    public Enum build(IDataFactoryContext context, Class<Enum> enumClass) {
        Enum[] enums = enumClass.getEnumConstants();
        if(ArrayUtil.isNotEmpty(enums)) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            return enums[random.nextInt(enums.length)];
        }
        return null;
    }

}
