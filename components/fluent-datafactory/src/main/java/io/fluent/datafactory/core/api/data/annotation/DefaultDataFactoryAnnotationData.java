package io.fluent.datafactory.core.api.data.annotation;

import com.github.houbb.heaven.util.lang.StringUtil;
import io.fluent.datafactory.api.annotation.DataFactory;
import io.fluent.datafactory.api.core.IDataFactoryContext;
import io.fluent.datafactory.api.core.IRegexGen;
import io.fluent.datafactory.core.api.context.DefaultDataContext;
import io.fluent.datafactory.core.api.regex.DefaultRegexGen;
import io.fluent.datafactory.core.exception.DataFactoryRuntimeException;
import io.fluent.datafactory.core.support.factory.DataFactoryMapping;
import io.fluent.datafactory.core.util.DataPrimitiveUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @see DataFactory 注解默认实现
 * @author binbin.hou
 * @since 1.0.0
 */
public class DefaultDataFactoryAnnotationData extends AbstractAnnotationData<DataFactory> {

  /**
   * 新建对象实例
   *
   * @return 实现
   * @since 1.1.0
   */
  public static DefaultDataFactoryAnnotationData newInstance() {
    return new DefaultDataFactoryAnnotationData();
  }

  @Override
  protected Object buildDataValue(
      DataFactory dataFactory, IDataFactoryContext context, Class<?> tClass) {
    // 忽略字段，直接返回 null
    if (dataFactory == null || dataFactory.ignore()) {
      return null;
    }

    Field field = context.getCurrentField();
    Class<?> fieldType = field.getType();

    // 如果 regex 不为空，直接返回 regex 信息
    IRegexGen regexGen = new DefaultRegexGen();
    final String regex = dataFactory.regex();
    if (StringUtil.isNotEmpty(regex)) {
      if (fieldType.isPrimitive()) {
        fieldType = DataPrimitiveUtil.getReferenceType(fieldType);
      }
      final String regexResult = regexGen.generate(regex);
      return newInstance(fieldType, regexResult);
    }

    // 设置 DataFactory 注解信息，便于获得。
    if (context instanceof DefaultDataContext) {
      DefaultDataContext defaultDataContext = (DefaultDataContext) context;
      defaultDataContext.setDataFactory(dataFactory);
    }

    return DataFactoryMapping.getData(fieldType).build(context, fieldType);
  }

  /**
   * 创建对应的实例 1. 根据类的 class 直接创建。
   *
   * @param fieldType 字段类型
   * @param string 字符串
   * @return 结果
   */
  private Object newInstance(Class<?> fieldType, final String string) {
    // 如果为字符串，考虑到性能开销，直接返回本身
    if (String.class.equals(fieldType)) {
      return string;
    }

    // 其他类型，当为空时，则视为 null
    if (StringUtil.isEmpty(string)) {
      return null;
    }

    try {
      // 获取所有的构造器，直接反射调用 constructor(string)
      Constructor constructor = fieldType.getConstructor(String.class);
      return constructor.newInstance(string);
    } catch (NoSuchMethodException
        | IllegalAccessException
        | InstantiationException
        | InvocationTargetException e) {
      // TODO: 这里应该考虑到有些没有提供 String 构造器的类。
      throw new DataFactoryRuntimeException(e);
    }
  }
}
