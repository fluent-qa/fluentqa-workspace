package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.data.annotation.AbstractNumberData;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class LongData extends AbstractNumberData implements IData<Long> {

    @Override
    public Long build(IDataFactoryContext context, Class<Long> booleanClass) {
        final String string = super.contactInt(context);
        return Long.valueOf(string);
    }

}
