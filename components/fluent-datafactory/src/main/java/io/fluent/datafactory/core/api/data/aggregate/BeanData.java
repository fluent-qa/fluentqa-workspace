package io.fluent.datafactory.core.api.data.aggregate;

import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import io.fluent.datafactory.api.annotation.DataFactory;
import io.fluent.datafactory.api.core.IAnnotationData;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.core.api.context.DefaultDataContext;
import io.fluent.datafactory.core.api.data.annotation.DefaultDataFactoryAnnotationData;
import io.fluent.datafactory.core.exception.DataFactoryRuntimeException;
import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import io.fluent.datafactory.core.util.InnerDataUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanData<T> implements IData<T> {

  @Override
  @SuppressWarnings("all")
  public T build(IDataFactoryContext context, Class<T> tClass) {
    try {
      List<Field> fieldList = ClassUtil.getAllFieldList(tClass);
      T instance = ClassUtil.newInstance(tClass);

      for (Field field : fieldList) {
        if (Modifier.isFinal(field.getModifiers())) {
          continue;
        }
        // 初始化上下文
        buildContext(context, field);

        // 字段的类型
        Object value = getFieldDataValue(field, context);

        // 设置对应的值
        field.set(instance, value);
      }
      return instance;
    } catch (IllegalAccessException e) {
      throw new DataFactoryRuntimeException(e);
    }
  }

  /**
   * 获取字段对应的数据值
   *
   * @param field 字段
   * @return 结果
   * @since 1.1.0
   */
  @SuppressWarnings("all")
  private Object getFieldDataValue(final Field field, final IDataFactoryContext context) {
    // 字段的类型
    Class<?> fieldClass = field.getType();

    // 是否为自定义注解
    IAnnotationData annotationData = InnerDataUtil.getDefineDataAnnotation(field);

    // 是否为对应的信息
    Object value = null;
    DataFactory dataFactory = field.getAnnotation(DataFactory.class);
    if (dataFactory != null) {
      // 用户自定义的实现方式
      if (dataFactory.data() != IData.class) {
        value = ClassUtil.newInstance(dataFactory.data()).build(context, fieldClass);
      } else {
        // 默认的实现
        value =
            DefaultDataFactoryAnnotationData.newInstance()
                .setAnnotation(dataFactory)
                .build(context, fieldClass);
      }
    } else if (annotationData != null) {
      // 用户自定义注解
      value = annotationData.build(context, fieldClass);
    } else {
      // 没有任何注解的时候
      value = DataFactoryDataUtil.build(context, fieldClass);
    }

    return value;
  }

  /**
   * 构建执行的上下文
   *
   * @param context 执行的上下文
   * @param field 字段信息
   * @return 执行的上下问
   */
  @SuppressWarnings("all")
  private IDataFactoryContext buildContext(IDataFactoryContext context, Field field) {
    final Class fieldType = field.getType();
    Type type = field.getGenericType();

    if (context instanceof DefaultDataContext) {
      DefaultDataContext defaultDataContext = (DefaultDataContext) context;
      defaultDataContext.setCurrentField(field);
      if (type instanceof ParameterizedType) {
        List<Class> genericTypeList = new ArrayList<>();
        // 可遍历的集合
        if (ClassTypeUtil.isIterable(fieldType)) {
          Class genericType = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
          genericTypeList.add(genericType);
          defaultDataContext.setGenericList(genericTypeList);
        }

        // map
        if (Map.class.isAssignableFrom(fieldType)) {
          Class genericKeyType = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
          Class genericValueType = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
          genericTypeList.add(genericKeyType);
          genericTypeList.add(genericValueType);
          defaultDataContext.setGenericList(genericTypeList);
        }
      }
    }

    return context;
  }
}
