# Quick Dao - 给测试快速操作的JAVA库

The initial thoughts:
> Simple DAO - Simple database access methods
> A simple DAO implementation to QA Daily Usage:
> 1. [X] Create DAO by database connection settings
> 2. [X] DAO access database:
>  1. [X] Query to Bean
>  2. [X] Execute SQL Statement
>  3. [X] Insert/Save/SaveOrUpdate
> 3. [X] Multiple Data Source
>  1. [X] Multiple Database Holder
>  2. [X] Multiple SQL execution in different Database
      These are most frequent used functionalities for QA.

快速操作数据库:

好处: 免去了mybatis/jpa等库的各种学习成本，就是SQL+变量
坏处: 可能只适合测试使用,不适合生产环境使用

1. 创建连接Dao
2. 直接执行SQL
3. 直接可以绑定变量
4. 更具外部给定的输入选择不同的数据源进行操作数据库

## 创建连接Dao

```java
  DataSourceSetting setting=DataSourceSetting.builder().
  url("jdbc:postgresql://127.0.0.1:7432/test_hub?currentSchema=demo")
  .driver("org.postgresql.Driver")
  .username("postgres").password("changeit").build();
  QuickDao dao=QuickDao.createDao("config/db.setting");
```

## 直接执行SQL

- 直接SQL
- 占位符方式传递参数
- 绑定变量传递参数

```java
@Test
public void testQuery(){
  var queryResult=dao.query("select  * from hero");
  for(Entity entity:queryResult){
  System.out.println(entity.keySet());
  System.out.println(entity.values());
  }
  }

@Test
public void testQueryWithParameters(){
  var queryResult=dao.query("select  * from hero where name=?","test");
  for(Entity entity:queryResult){
  System.out.println(entity.keySet());
  System.out.println(entity.values());
  }
  }

@Test
public void testQueryWithBindParams(){
  Map<String, Object> params=MapUtil.builder("name",(Object)"test2").build();
  var queryResult=dao.query("select  * from hero where name=@name",
  params);
  for(Entity entity:queryResult){
  System.out.println(entity.keySet());
  System.out.println(entity.values());
  }
  }

```

## 执行SQL insert/delete

- 直接输入SQL可以直接执行
- 使用JAVA 类也可以直接操作

```shell
  @Test
  public void testSaveOrInsertEntity() {
    Entity e = Entity.create("hero").set("name", "test4")
      .set("secret_name", "100").set("age", 9000);

    HeroDemoEntity demoEntity = new HeroDemoEntity();
    demoEntity.setName("hero");
    demoEntity.setAge(10);
    demoEntity.setSecret_name("secret_name");
    dao.saveOrUpdate(demoEntity,"hero");
    dao.saveOrUpdate(e, "hero", "name", "secret_name"); //for upsert error
  }

  @Test
  public void testExecute() {
    int count = dao.execute("delete from hero where name='test2'");
    System.out.println(count);
  }
```

## 根据外部给定的输入选择不同的数据源进行操作数据库

- 数据库例连接配置
- SQL输入+变量都是配置

```java

@Test
public void testDaoService(){
  String connectConfig="{\n"+
  "  \"url\" :\"jdbc:postgresql://127.0.0.1:7432/test_hub\",\n"+
  "  \"user\":\"postgres\",\n"+
  "  \"password\": \"changeit\"\n"+
  "}";
  SqlRequest request=SqlRequest.createRequest("select * from data_sources where name=@name");
  String bindvalue="{\n"+
  "\"name\":\"本地测试环境\"\n"+
  "    }";
  request.bindParameterValues(bindvalue);
  request.dsConfig(connectConfig);
  SqlService service=new SqlService();
  SqlQueryResponse response=service.query(request);
  System.out.println(JSONUtil.toJsonPrettyStr(response));
  }
```

