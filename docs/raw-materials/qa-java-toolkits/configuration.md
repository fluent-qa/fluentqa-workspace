# Configuration

## Load Configuration Property

- Setting file:

```shell
[demo]
driver = com.mysql.jdbc.Driver
url = jdbc:mysql://fedora.vmware:3306/extractor
user = root${demo.driver}
pass = 123456
```

- How to load and Get Property
```java
  @Test
  @Story( "Get Configuration Property")
  public void test_LoadSetting(){
    var appConfig = AppConfig.create("config/app2.setting");
    assertNotNull(appConfig);
    assertEquals(appConfig.getConfigSet("demo").get("user"),"root${demo.driver}");
  }
```


## Get Property Bean

- getConfigSetBean
```java
var bean = appConfig.getConfigSetBean(DemoSetting.class);
    assertEquals(bean.getUser(),"root${demo.driver}");
```

