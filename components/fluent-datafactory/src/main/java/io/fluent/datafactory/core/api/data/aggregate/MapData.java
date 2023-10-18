package io.fluent.datafactory.core.api.data.aggregate;

import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * map 集合的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class MapData implements IData<Map> {

    @Override
    @SuppressWarnings("all")
    public Map build(IDataFactoryContext context, Class<Map> mapClass) {
        final int size = InnerDataUtil.randomSize();
        Map map = new HashMap(size);

        List<Class> genericTypeList = context.getGenericList();
        if(CollectionUtil.isEmpty(genericTypeList)) {
            return map;
        }

        for(int i = 0; i < size; i++) {
            final Object key = DataFactoryDataUtil.build(context, genericTypeList.get(0));
            final Object value = DataFactoryDataUtil.build(context, genericTypeList.get(1));
            map.put(key, value);
        }

        return map;
    }

    /**
     * 创建对应的实例
     * @param mapClass 类
     * @return 结果
     */
    private Map newInstance(final Class<Map> mapClass) {
        try {
            return ClassUtil.newInstance(mapClass);
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

}
