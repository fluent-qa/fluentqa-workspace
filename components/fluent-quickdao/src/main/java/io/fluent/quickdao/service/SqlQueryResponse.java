package io.fluent.quickdao.service;

import cn.hutool.db.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class SqlQueryResponse {

    private List<Entity> result;
}
