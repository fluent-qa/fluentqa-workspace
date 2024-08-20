package io.fluent.quickdao.datasource.model;

import java.util.*;
import lombok.Data;

@Data
public class TableInfoQuery {
  private String tableInfoQuery;
  private List<String> paramList = new ArrayList<>();
  private Map<String, Object> parameters = new HashMap<>();

  public TableInfoQuery addParameter(String parameter) {
    paramList.add(parameter);
    return this;
  }

  public TableInfoQuery addQueryParameterValue(String parameter, String value) {
    parameters.put(parameter, value);
    return this;
  }

  public static TableInfoQuery postgresqlTableInfoQuery() {
    TableInfoQuery query = new TableInfoQuery();
    query.setTableInfoQuery(
        "SELECT c.table_name,c.column_name,\n"
            + "\t\tc.udt_name data_type, t.table_type,\n"
            + "\t\tcase when k.constraint_name is null then 0 else 1 end is_pk \n"
            + "\tFROM information_schema.tables t join \n"
            + "\t\tinformation_schema.columns c \n"
            + "\t\t on t.table_name = c.table_name left join \n"
            + "\t\tinformation_schema.key_column_usage k\n"
            + "\t\t\ton c.table_name = k.table_name\n"
            + "\t\t\tand c.column_name = k.column_name\n"
            + "\t\t\tand RIGHT(constraint_name, 4) = 'pkey'\n"
            + "\tWHERE c.table_schema = @schema\n"
            + "\tORDER BY  c.table_name, c.ordinal_position;\n");
    query.addParameter("scheme");
    return query;
  }
}
