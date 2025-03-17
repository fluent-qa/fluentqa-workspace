package io.fluent.base.handlers;

import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.TagsFetchHandler;
import xyz.erupt.core.cache.EruptCache;
import xyz.erupt.core.cache.EruptCacheLRU;
import xyz.erupt.core.util.EruptAssert;

@Component
public class SqlTagFetchHandler implements TagsFetchHandler {
  @Resource private JdbcTemplate jdbcTemplate;
  private final EruptCache<List<String>> tagsCache = new EruptCacheLRU<>(100);

  public SqlTagFetchHandler() {}

  @Override
  public List<String> fetchTags(String[] params) {
    EruptAssert.notNull(params, SqlTagFetchHandler.class.getSimpleName() + " → params not found");
    String key = SqlTagFetchHandler.class.getName() + ":" + params[0];
    return this.tagsCache.getAndSet(
        key,
        3000L,
        new Supplier<List<String>>() {
          @Override
          public List<String> get() {
            System.out.println("get tags");
            return jdbcTemplate.query(params[0], (rs, i) -> rs.getString(1));
          }
        });
  }
}
