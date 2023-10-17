package io.fluent.quickdao.entity;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.db.Entity;
import io.fluent.quickdao.annotations.QuickDaoColumn;

import java.lang.reflect.Field;

public class EntityUtil {

    public static <T> Entity convertToEntity(T entity, String tableName) {
        if (entity instanceof Entity) {
            ((Entity) entity).setTableName(tableName);
            return (Entity) entity;
        }
        Entity e = Entity.create(tableName);
        Field[] fields = ReflectUtil.getFields(entity.getClass());
        for (Field field : fields) {
            QuickDaoColumn a = field.getDeclaredAnnotation(QuickDaoColumn.class);
            if (a != null) {
                e.set(a.name(), ReflectUtil.getFieldValue(entity, field));
            } else {
                e.set(field.getName(), ReflectUtil.getFieldValue(entity, field));
            }
        }
        return e;
    }
}
