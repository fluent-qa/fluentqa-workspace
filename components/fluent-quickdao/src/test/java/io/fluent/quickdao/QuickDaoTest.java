//package io.fluentqa.quickdao;
//
//
//import cn.hutool.core.map.MapUtil;
//import cn.hutool.db.Entity;
//import cn.hutool.json.JSONUtil;
//import io.fluentqa.quickdao.datasource.model.DataSourceSetting;
//import io.fluentqa.quickdao.service.SqlQueryResponse;
//import io.fluentqa.quickdao.service.SqlRequest;
//import io.fluentqa.quickdao.service.SqlService;
//import org.junit.jupiter.api.Test;
//
//import java.util.Map;
//
//
//public class QuickDaoTest {
//  DataSourceSetting setting = DataSourceSetting.builder().
//    url("jdbc:sqlite:sample.db")
////    url("jdbc:postgresql://127.0.0.1:7432/test_hub?currentSchema=demo")
////    .driver("org.sqlite.JDBC.Driver")
////    .username("postgres").password("changeit")
//    .build();
//  QuickDao dao = QuickDao.createDao("config/db.setting");
//
//  @Test
//  public void testQuery() {
//    var queryResult = dao.query("select  * from hero");
//
//    for (Entity entity : queryResult) {
//      System.out.println(entity.keySet());
//      System.out.println(entity.values());
//    }
//  }
//
//  @Test
//  public void testQueryWithParameters() {
//    var queryResult = dao.query("select  * from hero where name=?", "test");
//    for (Entity entity : queryResult) {
//      System.out.println(entity.keySet());
//      System.out.println(entity.values());
//    }
//  }
//
//  @Test
//  public void testQueryWithBindParams() {
//    Map<String, Object> params = MapUtil.builder("name", (Object) "test2").build();
//    var queryResult = dao.query("select  * from hero where name=@name",
//      params);
//    for (Entity entity : queryResult) {
//      System.out.println(entity.keySet());
//      System.out.println(entity.values());
//    }
//  }
//
//  @Test
//  public void testInsert() {
//    Entity e = Entity.create("hero").set("name", "test4").set("secret_name", 100);
//    dao.saveOrUpdate(e, "hero", "name");
//  }
//
//  @Test
//  public void testUpsert() {
//    Entity e = Entity.create("hero").set("name", "test2")
//      .set("secret_name", "100").set("age", 100);
//    dao.upsert(e, "hero", "name"); //for upsert error
//  }
//
//  @Test
//  public void testSaveOrInsert() {
//    Entity e = Entity.create("hero").set("name", "test4")
//      .set("secret_name", "100").set("age", 9000);
//
//    dao.saveOrUpdate(e, "hero", "name", "secret_name"); //for upsert error
//  }
//
//  @Test
//  public void testSaveOrInsertEntity() {
//    Entity e = Entity.create("hero").set("name", "test4")
//      .set("secret_name", "100").set("age", 9000);
//
//    HeroDemoEntity demoEntity = new HeroDemoEntity();
//    demoEntity.setName("hero");
//    demoEntity.setAge(10);
//    demoEntity.setSecret_name("secret_name");
//    dao.saveOrUpdate(demoEntity,"hero");
//    dao.saveOrUpdate(e, "hero", "name", "secret_name"); //for upsert error
//  }
//
//  @Test
//  public void testExecute() {
//    int count = dao.execute("delete from hero where name='test2'");
//    System.out.println(count);
//  }
//
//  @Test
//  public void testDaoService() {
//    String connectConfig = "{\n" +
//      "  \"url\" :\"jdbc:postgresql://127.0.0.1:7432/test_hub\",\n" +
//      "  \"user\":\"postgres\",\n" +
//      "  \"password\": \"password\"\n" +
//      "}";
//    SqlRequest request = SqlRequest.createRequest("select * from data_sources where name=@name");
//    String bindvalue = "{\n" +
//      "\"name\":\"本地测试环境\"\n" +
//      "    }";
//    request.bindParameterValues(bindvalue);
//    request.dsConfig(connectConfig);
//    SqlService service = new SqlService();
//    SqlQueryResponse response = service.query(request);
//    System.out.println(JSONUtil.toJsonPrettyStr(response));
//  }
//
//}
