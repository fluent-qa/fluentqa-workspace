package io.fluent.quickdao.datasource.model;

import lombok.Data;

@Data
public class TableColumn {
  private String columnName;
  private String tableName;
  private String tableComment;
  private String dataType;
  private String tableType;
  private boolean isPk;
  private String comments;
}
