# API 定义阶段

## 接口定义文档格式


## 工具使用

## Code Generation

安装： 
```sh
npm install @openapitools/openapi-generator-cli -g
```

## 生成Python-FastAPI 代码

```sh
openapi-generator-cli generate -i api-definition/openapi3-todo.yaml -g python-fastapi -o todo
```

```sh
make todo-py
poetry init
poetry add fastapi-code-generator -D
fastapi-codegen --input openapi3-todo.yaml --output app
```

## 生成springboot 代码

```sh
openapi-generator-cli generate -i api-definition/openapi3-todo.yaml -g spring -o todo-java
```
