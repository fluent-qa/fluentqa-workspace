{
  "properties" : { },
  "id" : "ff66c9fd080248248175f895e738748d",
  "script" : null,
  "groupId" : "45635640034643dbb217b6dea3ad5689",
  "name" : "get-cases",
  "createTime" : null,
  "updateTime" : 1706178148319,
  "lock" : null,
  "createBy" : null,
  "updateBy" : null,
  "path" : "/testcases",
  "method" : "GET",
  "parameters" : [ ],
  "options" : [ {
    "name" : "require_login",
    "value" : "true",
    "description" : "该接口需要登录才允许访问",
    "required" : false,
    "dataType" : "String",
    "type" : null,
    "defaultValue" : null,
    "validateType" : null,
    "error" : null,
    "expression" : null,
    "children" : null
  } ],
  "requestBody" : "",
  "headers" : [ ],
  "paths" : [ ],
  "responseBody" : "{\n    \"code\": 1,\n    \"message\": \"success\",\n    \"data\": [\n        {\n            \"id\": 90,\n            \"create_by\": \"erupt\",\n            \"create_time\": \"2024-01-07T13:25:35.729+00:00\",\n            \"update_by\": \"erupt\",\n            \"update_time\": \"2024-01-16T09:06:51.627+00:00\",\n            \"valid\": true,\n            \"expected_result\": null,\n            \"feature\": \"测试功能点A\",\n            \"precondition\": \"1. 操作步骤1\\n2. 操作步骤2\",\n            \"priority\": \"P2\",\n            \"steps\": null,\n            \"summary\": \"登录成功\",\n            \"uuid\": \"e08787c1-2f38-4159-b720-3bf49c9694ec\",\n            \"product_id\": 82,\n            \"parent_product_id\": null,\n            \"root_product_id\": null\n        }\n    ],\n    \"timestamp\": 1706177415349,\n    \"executeTime\": 7\n}",
  "description" : null,
  "requestBodyDefinition" : null,
  "responseBodyDefinition" : null
}
================================
var sql = """
select * from test_cases
"""
return db.select(sql)