package io.fluent.datafactory.core.api.data.math;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;

import java.math.BigInteger;


@AutoService(IData.class)
public class BigIntegerData extends AbstractNumberData implements IData<BigInteger> {

    @Override
    public BigInteger build(IDataFactoryContext context, Class<BigInteger> bigIntegerClass) {
        final String string = super.contactInt(context);
        return new BigInteger(string);
    }

}
