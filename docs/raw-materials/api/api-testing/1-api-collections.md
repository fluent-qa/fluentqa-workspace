# API 接口定义

接口定义阶段主要是定义了系统间调用的方式. 如果从本地和远程API的角度理解的话:

- 本地API调用,直接函数调用: 函数+参数
```sh
func(arg1,arg2)
```
- 远程API调用: 本质也是函数+参数
  * 使用远程协议如http/http2/rpc 传递
  * 函数+参数隐含在协议中
  * 协议层处理大部分可以通过框架实现，从而让远程调用看起来像本地调用一样
  
```shell
protocol(func(arg1,arg2))
```
--- 

## 使用 API设计工具

- stoplight studio
- insominia

## HTTP api 来源

- Postman 文件
- Swagger 文件
- grpc
- 自定义协议

## HTTP API 设计和管理工具
- 设计工具
  - spotlint
- api 调用工具
  - postman
  - insomia

## API统一收集方式

1. POSTMAN/SWAGGER文件上传统一管理
2. 接口记录保存




