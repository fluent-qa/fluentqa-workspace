package io.fluent.quickdao.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SqlExecuteResponse {

  private int count;
}
