package io.fluent.quickdao.service;

import cn.hutool.json.JSONUtil;
import io.fluent.quickdao.datasource.model.DataSourceSetting;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SqlRequest {
   private String sql;
   private List<String> paramValues;
   private Map<String,Object> bindParamValues;
   private DataSourceSetting dsConfig;

   public SqlRequest dsConfig(String configJson){
      DataSourceSetting setting = JSONUtil.toBean(configJson,DataSourceSetting.class);
      this.setDsConfig(setting);
      return this;
   }

   public SqlRequest bindParameterValues(String parameterValues){
      Map<String,Object> parameters = JSONUtil.toBean(parameterValues,Map.class);
      this.setBindParamValues(parameters);
      return this;
   }

   public static SqlRequest createRequest(String sql){
      SqlRequest request = new SqlRequest();
      request.setSql(sql);
      return request;
   }
}
