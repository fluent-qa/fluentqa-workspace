package io.fluent.datafactory.core.api.data.aggregate;

import com.github.houbb.heaven.util.lang.ObjectUtil;
import io.fluent.datafactory.api.core.IData;
import io.fluent.datafactory.api.core.IDataFactoryContext;

/**
 * null 对象数据实现 1. 使用空对象模式。
 *
 * @author binbin.hou date 2019/2/26
 * @since 0.0.1
 */
public final class NullData implements IData {

  /** 空对象模式实现 */
  public static final IData INSTANCE = new NullData();

  @Override
  public Object build(IDataFactoryContext context, Class aClass) {
    return null;
  }

  /**
   * 是否为空对象模式
   *
   * @param data 类型
   * @return 是否
   */
  public static boolean isNullData(final IData data) {
    if (ObjectUtil.isNull(data)) {
      return false;
    }
    return INSTANCE.getClass().equals(data.getClass());
  }
}
