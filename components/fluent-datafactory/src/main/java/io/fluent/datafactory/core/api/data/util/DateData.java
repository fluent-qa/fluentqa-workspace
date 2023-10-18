package io.fluent.datafactory.core.api.data.util;


import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;

import java.util.Date;

/**
 * 日期类数据初始化
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class DateData implements IData<Date> {
    @Override
    public Date build(IDataFactoryContext context, Class<Date> dateClass) {
        return new Date();
    }
}
