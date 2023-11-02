## Code Generation

安装： 
```sh
npm install @openapitools/openapi-generator-cli -g
```
--- 

## 生成Python-FastAPI 代码

```sh
openapi-generator-cli generate -i spec/openapi3-todo.yaml -g python-fastapi -o todo-simple --skip-validate-spec
```
--- 

```sh
make todo-py
poetry init
poetry add fastapi-code-generator -D
poetry run fastapi-codegen --input ../../spec/openapi3-todo.yaml  --output app
```
--- 

## 生成springboot 代码

```sh
openapi-generator-cli generate -i 1-definition/openapi3-todo.yaml -g spring  --skip-validate-spec  -o todo-java
```


