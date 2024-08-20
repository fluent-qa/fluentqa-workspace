package io.fluent.quickdao.datasource.model;

import java.util.HashMap;
import java.util.Map;

public class TableInfoQueryFinder {

  private Map<String, TableInfoQuery> tableInfoQueries = new HashMap<>();

  public TableInfoQueryFinder() {
    tableInfoQueries.put("postgresql", TableInfoQuery.postgresqlTableInfoQuery());
  }

  public TableInfoQuery getTableInfoQuery(String dbType) {
    return tableInfoQueries.get(dbType);
  }

  public TableInfoQueryFinder register(String dbType, TableInfoQuery query) {
    this.tableInfoQueries.put(dbType.toLowerCase(), query);
    return this;
  }

  public TableInfoQuery find(String dbType) {
    return this.tableInfoQueries.get(dbType.toLowerCase());
  }
}
