package io.fluentqa.builtin;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 反射工具类.
 * <p>
 * 提供调用getter/setter方法, 访问私有变量, 调用私有方法, 获取泛型类型Class, 被AOP过的真实类等工具函数.
 */
@SuppressWarnings("unchecked")
@Slf4j
public class ReflectionUtils extends ReflectUtil {
  private static final String SETTER_PREFIX = "set";
  private static final String GETTER_PREFIX = "get";
  private static final String CGLIB_CLASS_SEPARATOR = "$$";

  private ReflectionUtils() {
  }

  /**
   * 反射调用方法
   *
   * @param obj  实例
   * @param m    方法
   * @param args 参数
   * @return
   */
  public static Object invokeMethod(Object obj, Method m, Object... args) {
    try {
      return m.invoke(obj, args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      log.warn("error_result={}", e);
    }
    return null;
  }

  /**
   * 调用Getter方法.
   */
  public static Object invokeGetter(Object obj, String propertyName) {
    String getterMethodName = GETTER_PREFIX + StrUtil.upperFirst(propertyName);
    if (getAccessibleMethod(obj, getterMethodName) == null) {
      getterMethodName = GETTER_PREFIX + propertyName;
    }
    return invokeMethod(obj, getterMethodName, new Class[]{}, new Object[]{});
  }


  /**
   * 调用Setter方法, 仅匹配方法名。
   */
  public static void invokeSetter(Object obj, String propertyName, Object value) {
    String setterMethodName = SETTER_PREFIX + StrUtil.upperFirst(propertyName);
    invokeMethodByName(obj, setterMethodName, new Object[]{value});
  }

  /**
   * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
   */
  public static Object getFieldValue(final Object obj, final String fieldName) {
    Field field = getAccessibleField(obj, fieldName);

    if (field == null) {
      throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
    }

    Object result = null;
    try {
      result = field.get(obj);
    } catch (IllegalAccessException e) {
      log.error("不可能抛出的异常{}", e.getMessage());
    }
    return result;
  }

  /**
   * 获取字段
   *
   * @param object 实例
   * @param field  字段实例
   * @return
   */
  public static Object getFieldValue(final Object object, Field field) {
    field.setAccessible(true);
    try {
      return field.get(object);
    } catch (IllegalAccessException e) {
      log.error("不可能抛出的异常{}", e.getMessage());
      return null;
    }
  }

  /**
   * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
   */
  public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
    Field field = getAccessibleField(obj, fieldName);

    if (field == null) {
      throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
    }

    try {
      field.set(obj, value);
    } catch (IllegalAccessException e) {
      log.error("不可能抛出的异常:{}", e.getMessage());
    }
  }


  /**
   * 直接调用对象方法, 无视private/protected修饰符.
   * 用于一次性调用的情况，否则应使用getAccessibleMethod()函数获得Method后反复调用.
   * 同时匹配方法名+参数类型，
   */
  public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
                                    final Object[] args) {
    Method method = getAccessibleMethod(obj, methodName, parameterTypes);
    if (method == null) {
      throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
    }

    try {
      return method.invoke(obj, args);
    } catch (Exception e) {
      throw convertReflectionExceptionToUnchecked(e);
    }
  }

  /**
   * 直接调用对象方法, 无视private/protected修饰符，
   * 用于一次性调用的情况，否则应使用getAccessibleMethodByName()函数获得Method后反复调用.
   * 只匹配函数名，如果有多个同名函数调用第一个。
   */
  public static Object invokeMethodByName(final Object obj, final String methodName, final Object[] args) {
    Method method = getAccessibleMethodByName(obj, methodName);
    if (method == null) {
      throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
    }

    try {
      return method.invoke(obj, args);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e.getTargetException());
    } catch (IllegalAccessException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * 循环向上转型, 获取对象的DeclaredField, 并强制设置为可访问.
   * <p>
   * 如向上转型到Object仍无法找到, 返回null.
   */
  public static Field getAccessibleField(final Object obj, final String fieldName) {
    for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
      try {
        Field field = superClass.getDeclaredField(fieldName);
        makeAccessible(field);
        return field;
      } catch (NoSuchFieldException e) {
        log.debug("{} is not found", fieldName);
      }
    }
    return null;
  }

  public static List<Field> getAccessibleFields(Class clazz) {
    List<Field> fields = Lists.newArrayList();
    for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {

      Collections.addAll(fields, superClass.getDeclaredFields());
    }
    return fields;
  }

  /**
   * 获取字段的类型名字
   *
   * @param obj
   * @param fieldName
   * @return
   */
  public static String getAccessibleFieldTypeName(final Object obj, final String fieldName) {
    for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
      try {
        Field field = superClass.getDeclaredField(fieldName);
        makeAccessible(field);
        return field.getType().getSimpleName();
      } catch (NoSuchFieldException e) {// NOSONAR
        log.debug("{} is not found", fieldName);
      }
    }
    return null;
  }

  public static Pair getFieldTypeAndValue(final Object obj, final String fieldName) {
    for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
      try {
        Field field = superClass.getDeclaredField(fieldName);
        makeAccessible(field);
        return Pair.of(field.getType().getSimpleName(), field.get(obj));
      } catch (NoSuchFieldException e) {// NOSONAR
        log.debug("{} is not found", fieldName);
      } catch (IllegalAccessException e) {
        log.debug("{} is not accessible", fieldName);
      }
    }
    return null;
  }

  /**
   * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问.
   * 如向上转型到Object仍无法找到, 返回null.
   * 匹配函数名+参数类型。
   * <p>
   * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object... args)
   */
  public static Method getAccessibleMethod(final Object obj, final String methodName,
                                           final Class<?>... parameterTypes) {

    for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass()) {
      try {
        Method method = searchType.getDeclaredMethod(methodName, parameterTypes);
        makeAccessible(method);
        return method;
      } catch (NoSuchMethodException e) {
        // Method不在当前类定义,继续向上转型
      }
    }
    return null;
  }

  /**
   * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问.
   * 如向上转型到Object仍无法找到, 返回null.
   * 只匹配函数名。
   * <p>
   * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object... args)
   */
  public static Method getAccessibleMethodByName(final Object obj, final String methodName) {

    for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass()) {
      Method[] methods = searchType.getDeclaredMethods();
      for (Method method : methods) {
        if (method.getName().equals(methodName)) {
          makeAccessible(method);
          return method;
        }
      }
    }
    return null;
  }

  /**
   * 改变private/protected的方法为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨。
   */
  public static void makeAccessible(Method method) {
    if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
      && !method.isAccessible()) {
      method.setAccessible(true);
    }
  }

  /**
   * 改变private/protected的成员变量为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨。
   */
  public static void makeAccessible(Field field) {
    if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier
      .isFinal(field.getModifiers())) && !field.isAccessible()) {
      field.setAccessible(true);
    }
  }

  /**
   * 通过反射, 获得Class定义中声明的泛型参数的类型, 注意泛型必须定义在父类处
   * 如无法找到, 返回Object.class.
   * eg.
   * public UserDao extends HibernateDao<User>
   *
   * @param clazz The class to introspect
   * @return the first generic declaration, or Object.class if cannot be determined
   */
  public static <T> Class<T> getClassGenericType(final Class clazz) {
    return getClassGenericType(clazz, 0);
  }


  public static boolean isParameterizedList(Field field) {
    return ReflectionUtils.evalAssignableClass(field, List.class)
      && hasGenericParameter(field);
  }

  /**
   * check some field is assignable from some class
   *
   * @param clazz
   * @param field
   * @param <T>
   * @return
   */
  public static <T> boolean evalAssignableClass(Field field, Class<T> clazz) {
    return clazz.isAssignableFrom(field.getType());
  }

  /**
   * 判断field右面generic parameter
   *
   * @param field
   * @return
   */
  public static boolean hasGenericParameter(final Field field) {
    return field.getGenericType() instanceof ParameterizedType;
  }

  /**
   * 获取字段的泛型类
   *
   * @param field
   * @return
   */
  public static Class getGenericParameterClass(Field field) {
    if (!ReflectionUtils.hasGenericParameter(field)) return null;
    Type genericType = field.getGenericType();
    return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
  }

  /**
   * 获取给定对象的字段的泛型类
   *
   * @param obj
   * @param fieldName
   * @return
   */
  public static Class getGenericParameterClass(final Object obj, String fieldName) {
    Field field = getAccessibleField(obj, fieldName);
    if (field == null) return Object.class;
    if (!ReflectionUtils.hasGenericParameter(field)) return Object.class;
    Type genericType = field.getGenericType();
    return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
  }


  /**
   * 获取字段的泛型集合
   *
   * @param field
   * @return
   */
  public static List<Class> getGenericParameterClassList(Field field) {
    if (!ReflectionUtils.hasGenericParameter(field))
      return Collections.EMPTY_LIST;
    Type genericType = field.getGenericType();
    List<Class> clazzList = Lists.newArrayList();
    clazzList.addAll(Arrays.asList((Class[]) ((ParameterizedType) genericType).getActualTypeArguments()));
    return clazzList;
  }


  /**
   * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
   * 如无法找到, 返回Object.class.
   *
   * @param clazz clazz The class to introspect
   * @param index the Index of the generic declaration,start from 0.
   * @return the index generic declaration, or Object.class if cannot be determined
   */
  public static Class getClassGenericType(final Class clazz, final int index) {

    Type genType = clazz.getGenericSuperclass();

    if (!(genType instanceof ParameterizedType)) {
      log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
      return Object.class;
    }

    Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

    if (index >= params.length || index < 0) {
      log.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
        + params.length);
      return Object.class;
    }
    if (!(params[index] instanceof Class)) {
      log.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
      return Object.class;
    }

    return (Class) params[index];
  }

  /**
   * 获得用户的类名
   *
   * @param instance
   * @return
   */
  public static Class<?> getUserClass(Object instance) {
    Class clazz = instance.getClass();
    if (clazz != null
      && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
      Class<?> superClass = clazz.getSuperclass();
      if (superClass != null
        && !Object.class.equals(superClass)) {
        return superClass;
      }
    }
    return clazz;

  }

  /**
   * 将反射时的checked exception转换为unchecked com.auto.exception.
   */
  public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
    if ((e instanceof IllegalAccessException) || (e instanceof IllegalArgumentException)
      || (e instanceof NoSuchMethodException)) {
      return new IllegalArgumentException(e);
    } else if (e instanceof InvocationTargetException) {
      return new RuntimeException(((InvocationTargetException) e).getTargetException());
    } else if (e instanceof RuntimeException) {
      return (RuntimeException) e;
    }
    return new RuntimeException("Unexpected Checked Exception.", e);
  }

  /**
   * 是否可以转化为给定的类
   *
   * @param givenClass
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> boolean isGivenClass(Class<T> givenClass, Class<?> clazz) {
    return givenClass.isAssignableFrom(clazz);
  }

  /**
   * 是否可以转化为给定的类
   *
   * @param givenClass
   * @param field
   * @param <T>
   * @return
   */
  public static <T> boolean isGivenClass(Class<T> givenClass, Field field) {
    return isGivenClass(givenClass, field.getType());
  }

  /**
   * 是否可以转化为集合类
   *
   * @param givenClass
   * @param instance
   * @param <T>
   * @return
   */
  public static <T> boolean isGivenClassInstance(Class<T> givenClass, T instance) {
    return givenClass.isInstance(instance);
  }

  /**
   * 是否可以转化为给定的类的集合
   *
   * @param givenClass
   * @param field
   * @param <T>
   * @return
   */
  public static <T> boolean isGivenClassList(Class<T> givenClass, Field field) {
    if (!ReflectionUtils.isParameterizedList(field)) {
      return false;
    }
    Class listParameterClass = ReflectionUtils.getGenericParameterClass(field);
    return isGivenClass(givenClass, listParameterClass);
  }

  public static <T> T getClassLevelAnnotation(Class clazz, Class annotation) {
    if (clazz.getAnnotation(annotation) == null) throw new RuntimeException(
      String.format("[%s] class doesn't have [%s] annotation",
        clazz.getSimpleName(), annotation.getSimpleName()));
    return (T) clazz.getAnnotation(annotation);
  }

  public static <T> T getClassLevelAnnotation(Class clazz, String annotationName) {
    Annotation[] annotations = clazz.getAnnotations();
    for (Annotation annotation : annotations) {
      if (annotation.getClass().getSimpleName().equalsIgnoreCase(annotationName)) {
        return (T) annotation;
      }
    }
    throw new RuntimeException(
      String.format("[%s] class doesn't have [%s] annotation",
        clazz.getSimpleName(), annotationName));
  }
}
