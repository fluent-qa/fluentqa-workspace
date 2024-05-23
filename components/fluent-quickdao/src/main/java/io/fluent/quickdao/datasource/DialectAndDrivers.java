package io.fluent.quickdao.datasource;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.dialect.DriverNamePool;
import io.fluent.quickdao.exceptions.NoDbDriverFoundException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DialectAndDrivers {

  private static Map<String, String> DIALECT_DRIVER_MAPPING;
  private static String DEFAULT_DB_TYPE = "postgresql".toUpperCase();

  static {
    DIALECT_DRIVER_MAPPING = getAllDialectDriverMapping();
  }

  /**
   * Get All Dialect/DriverMapping
   *
   * @return @Map
   */
  public static Map<String, String> getAllDialectDriverMapping() {
    Map<String, Field> fields = ReflectUtil.getFieldMap(DriverNamePool.class);
    Map<String, String> result = new ConcurrentHashMap<>();
    fields.forEach(
        (s, field) -> {
          try {
            result.put(s.replaceAll("DRIVER_", ""), (String) field.get(DriverNamePool.class));
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }
        });
    return result;
  }

  public String getDriverByDbType(String dbType) {
    String driver = DIALECT_DRIVER_MAPPING.get(dbType.toUpperCase());
    if (StrUtil.isEmpty(driver)) {
      throw new NoDbDriverFoundException(
          "%s is not found,please use driver in %s ".formatted(dbType, getAllDbType()));
    }
    return driver;
  }

  public void registerDbDriver(String dbType, String dbDriver) {
    DIALECT_DRIVER_MAPPING.put(dbType, dbDriver);
  }

  public Set<String> getAllDbType() {
    return DIALECT_DRIVER_MAPPING.keySet();
  }
}
