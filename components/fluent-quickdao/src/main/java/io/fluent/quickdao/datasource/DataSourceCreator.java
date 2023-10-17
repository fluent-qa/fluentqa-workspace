package io.fluent.quickdao.datasource;


import cn.hutool.core.util.StrUtil;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.setting.Setting;
import io.fluent.quickdao.datasource.model.DataSourceSetting;

import javax.sql.DataSource;

public class DataSourceCreator {
  private static DialectAndDrivers drivers = new DialectAndDrivers();

  public static DataSource createDataSource(DataSourceSetting dsModel) {
    DSFactory factory = DSFactory.create(dsModel.toSetting());
    return factory.getDataSource();
  }


  private static String whichDriver(DataSourceSetting setting) {
    if (StrUtil.isNotEmpty(setting.getDriver())) return setting.getDriver();
    return drivers.getDriverByDbType(setting.getDbType());
  }

  public static DataSource createDateSource(Setting setting){
    return DSFactory.create(setting).getDataSource();
  }
}
