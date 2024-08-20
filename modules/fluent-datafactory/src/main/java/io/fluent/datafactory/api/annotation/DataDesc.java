package io.fluent.datafactory.api.annotation;

import io.fluent.datafactory.api.core.IAnnotationData;
import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataDesc {

  /**
   * 数据条件实现类
   *
   * @return 实现类 class
   */
  Class<? extends IAnnotationData> value();
}
