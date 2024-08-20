package io.fluent.quickdao.service;

import cn.hutool.db.Entity;
import io.fluent.quickdao.QuickDao;
import java.util.List;

public class SqlService {

  public SqlExecuteResponse execute(SqlRequest request) {
    QuickDao dao = QuickDao.createDao(request.getDsConfig());
    int result = dao.execute(request.getSql(), request.getBindParamValues());
    return SqlExecuteResponse.builder().count(result).build();
  }

  public SqlQueryResponse query(SqlRequest request) {
    QuickDao dao = QuickDao.createDao(request.getDsConfig());
    List<Entity> result = dao.query(request.getSql(), request.getBindParamValues());
    return SqlQueryResponse.builder().result(result).build();
  }
}
