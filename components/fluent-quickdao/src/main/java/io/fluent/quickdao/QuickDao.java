package io.fluent.quickdao;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.setting.Setting;
import io.fluent.quickdao.entity.EntityUtil;
import io.fluent.quickdao.exceptions.DbExecutionFoundException;
import io.fluent.quickdao.datasource.DataSourceCreator;
import io.fluent.quickdao.datasource.model.DataSourceSetting;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class QuickDao {
  DataSourceSetting dsConfig;
  Db db;
  DataSource ds;


  public static <T extends DataSourceSetting> QuickDao createDao(T dsConfig){
     QuickDao dao = new QuickDao();
     dao.dsConfig = dsConfig;
     dao.ds = DataSourceCreator.createDataSource(dsConfig);
     dao.db = Db.use(dao.ds);
     return dao;
  }

  /**
   *  Create DAO From Setting files
   * @param settingPath
   * @return
   */
  public static QuickDao createDao(String settingPath){
      Setting setting = new Setting(settingPath);
      setting.autoLoad(true);
    return buildDao(setting);
  }

  public static QuickDao createDao(){
    Setting setting = new Setting();
    setting.autoLoad(true);
    return buildDao(setting);
  }

  private static QuickDao buildDao(Setting setting) {
    QuickDao dao = new QuickDao();
    dao.ds = DataSourceCreator.createDateSource(setting);
    dao.db = Db.use(dao.ds);
    return dao;
  }

  public Entity queryOne(String query,Object ...parameters){
    try {
      return this.getDb().queryOne(query,parameters);
    } catch (SQLException e) {
      throw new DbExecutionFoundException(e);
    }
  }
  public List<Entity> query(String query,Object ...parameters){
      try {
         return this.getDb().query(query,parameters);
      } catch (SQLException e) {
        log.error("sql query error,error=",e);
        return Collections.emptyList();
      }
  }

  public List<Entity> query(String query, Map<String,Object> parameters){
    try {
      return this.getDb().query(query,parameters);
    } catch (SQLException e) {
      log.error("sql query error,error=",e);
      return Collections.emptyList();
    }
  }
  public int execute(String query,Object ...parameters){
    try {
      return this.getDb().execute(query,parameters);
    } catch (SQLException e) {
      throw new DbExecutionFoundException(e);
    }
  }
    public <T> void save(T entity,String tableName){
        Entity e = EntityUtil.convertToEntity(entity, tableName);
        try {
            db.insert(e);
        } catch (SQLException ex) {
            throw new DbExecutionFoundException(ex);
        }
    }

    public <T> void upsert(T entity, String tableName, String...uniqKeys){
      Entity e = EntityUtil.convertToEntity(entity, tableName);
      try {
        db.upsert(e,uniqKeys);
      } catch (SQLException ex) {
        throw new DbExecutionFoundException(ex);
      }
    }

  public <T> void saveOrUpdate(T entity,String tableName,String...findByKeys){
    Entity e = EntityUtil.convertToEntity(entity, tableName);
    try {
      db.insertOrUpdate(e,findByKeys);
    } catch (SQLException ex) {
      throw new DbExecutionFoundException(ex);
    }
  }

  public Db getDb() {
        return db;
    }
  /**
   * abstract to :
   * 1. before sql action
   * 2. sql action
   * 3. after sql action
   */

  public <T> List<T> queryForObjects(String query, Map<String,Object> parameters,Class<T> clazz){
      try {
          var queryResult =  this.getDb().query(query,parameters);
          return queryResult.stream().map(entity -> BeanUtil.copyProperties(entity,clazz))
                  .collect(Collectors.toList());
      } catch (SQLException e) {
          log.error("sql query error,error=",e);
          return Collections.emptyList();
      }
  }
}
