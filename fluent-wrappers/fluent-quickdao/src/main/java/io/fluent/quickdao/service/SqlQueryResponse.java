package io.fluent.quickdao.service;

import cn.hutool.db.Entity;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SqlQueryResponse {

  private List<Entity> result;
}
