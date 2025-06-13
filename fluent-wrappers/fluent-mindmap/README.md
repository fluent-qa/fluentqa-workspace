# FluentQA Workspace

> 一个面向软件质量保证(QA)的综合性Java工具平台，提供API测试管理、测试用例管理、第三方集成等功能

## 🎯 项目概述

FluentQA Workspace 是一个专为软件QA团队设计的综合性工作平台，旨在解决API自动化测试、测试用例管理、测试数据生成等日常QA工作中的痛点。项目基于Spring Boot + Erupt框架构建，提供了完整的Web管理界面和丰富的Java工具库。

### 核心特性

- 🔌 **API管理**: 支持Swagger/Postman文档导入，自动生成API测试用例
- 📋 **测试用例管理**: 支持思维导图导入，可视化测试用例管理
- 🔗 **第三方集成**: 集成飞书、Jira、Git等常用工具
- 📊 **数据工厂**: 提供测试数据生成和数据库操作工具
- 🖥️ **桌面应用**: 包含PC信息查看等实用工具

## 🏗️ 架构概览

```
FluentQA Workspace
├── fluent-apps/          # 应用层
│   ├── workspace/        # 主要Web应用
│   └── pcinfo/          # PC信息桌面应用
├── fluent-erupts/        # Erupt扩展模块
├── fluent-wrappers/      # 第三方集成封装
├── modules/             # 核心功能模块
├── components/          # 基础组件库
└── docs/               # 项目文档
```

## 🚀 技术栈

- **后端框架**: Spring Boot 2.7.18, Erupt Framework
- **数据库**: PostgreSQL, H2 (测试)
- **构建工具**: Maven 3.x
- **Java版本**: JDK 17
- **前端**: Erupt内置管理界面
- **测试框架**: JUnit 5, TestContainers

## 📦 核心模块

### 1. 应用层 (fluent-apps)

#### Workspace - QA管理平台
- **API管理**: 接口清单、测试记录、用例步骤管理
- **测试用例管理**: 支持思维导图导入的测试用例系统
- **产品配置**: 产品模块、项目配置管理
- **文件管理**: 测试文件上传和同步

#### PCInfo - 桌面工具
- 系统信息查看工具，支持Windows/Mac/Linux

### 2. 第三方集成 (fluent-wrappers)

| 模块 | 功能 | 集成服务 |
|------|------|----------|
| fluent-feishu | 飞书集成 | 消息发送、文档操作、多维表格 |
| fluent-jira | Jira集成 | 缺陷管理、项目跟踪 |
| fluent-git | Git集成 | GitHub API、仓库管理 |
| fluent-allure | 测试报告 | Allure报告生成 |
| fluent-excel | Excel操作 | 数据导入导出 |
| fluent-mindmap | 思维导图 | XMind/FreeMind解析 |
| fluent-quickdao | 数据库操作 | 快速数据访问 |
| fluent-httpclients | HTTP客户端 | API调用封装 |

### 3. 核心模块 (modules)

- **fluent-datafactory**: 测试数据生成工厂
- **fluent-openapi**: OpenAPI/Swagger解析
- **fluent-payment**: 支付相关功能
- **fluent-spring**: Spring扩展工具
- **fluent-base-ext**: 基础功能扩展

### 4. 基础组件 (components)

- **fluent-builtin**: 基础Java工具库 (基于Guava + Hutool)
- **fluent-testlibs**: 测试相关库集合
- **fluent-loader**: 依赖注入和加载器

## 🎯 主要功能

### API自动化测试平台

1. **接口信息管理**
   - 支持Swagger文档自动导入
   - Postman集合解析和导入
   - API版本管理和变更跟踪

2. **测试用例管理**
   - 可视化测试用例编辑
   - 测试步骤管理
   - 测试数据管理

3. **测试执行和报告**
   - 测试集批量执行
   - Allure测试报告生成
   - 测试结果统计分析

### 测试用例管理系统

- 思维导图格式测试用例导入 (XMind/FreeMind)
- 层级化产品模块管理
- 测试用例版本控制
- Excel格式导入导出

## 🚀 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- PostgreSQL 12+ (生产环境)

### 运行步骤

1. **克隆项目**
```bash
git clone https://github.com/fluent-qa/fluentqa-workspace.git
cd fluentqa-workspace
```

2. **编译项目**
```bash
mvn clean compile
```

3. **运行主应用**
```bash
cd fluent-apps/workspace
mvn spring-boot:run
```

4. **访问应用**
- 管理界面: http://localhost:8080
- 默认账号: admin/admin

### Docker部署

项目提供了多种服务的Docker配置：

```bash
# 启动PostgreSQL
docker-compose -f docker/postgresql/docker-compose.yml up -d

# 启动Supabase (包含完整的后端服务)
docker-compose -f docker/supabase/docker-compose.yml up -d
```

## 📁 项目结构

```
fluentqa-workspace/
├── ci/                     # CI/CD配置和脚本
├── components/             # 基础组件库
│   ├── fluent-builtin/    # 基础工具库
│   ├── fluent-testlibs/   # 测试库集合
│   └── fluent-loader/     # 加载器组件
├── docker/                # Docker配置文件
├── docs/                  # 项目文档
├── fluent-apps/           # 应用层
│   ├── pcinfo/           # PC信息工具
│   └── workspace/        # 主要Web应用
├── fluent-erupts/         # Erupt框架扩展
├── fluent-wrappers/       # 第三方服务集成
├── modules/               # 核心功能模块
├── scripts/               # 构建和部署脚本
└── pom.xml               # 主POM文件
```

## 🤝 贡献指南

欢迎提交Issue和Pull Request来帮助改进项目。

## 📄 许可证

本项目采用开源许可证，具体请查看LICENSE文件。

---

> 💡 **提示**: 这是一个活跃开发中的项目，功能在持续完善中。如有问题或建议，欢迎提交Issue。
