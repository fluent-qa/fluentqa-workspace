package io.fluent.datafactory.core.api.data.primitive;

import com.google.auto.service.AutoService;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;

/**
 * double 数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.7
 */
@AutoService(IData.class)
public class DoubleArrayData implements IData<double[]> {

    @Override
    public double[] build(IDataFactoryContext context, Class<double[]> aClass) {
        int size = InnerDataUtil.randomSize();
        double[] array = new double[size];
        for(int i = 0; i < size; i++) {
            array[i] = DataFactoryDataUtil.build(double.class);
        }
        return array;
    }

}
