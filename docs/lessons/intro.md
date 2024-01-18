# 无废话构建极简测试管理系统


无废话系列-极简测试管理系统-5分钟一个增删改查页面

看着各种测试大佬拿着高工资，其实他们都是写代码的，写测试平台难吗？
难也不难，无废话系列-极简测试管理系统主要就是告诉你不难的一面，

短短几行代码，让你就实现一个小功能，成就感满满，有了反馈才能继续前进呀。
要不然学了几个月代码，还是做不出一个功能，这代码是学不下去的。动手做点什么吧，真的不难！
视频就是为了展示这些都不难，10分钟左右一个小功能介绍，代码都不长。成就感满满。

## 资料参考

- erupts文档: https://www.yuque.com/erupts/erupt/sgx66o
- JAVA/MAVEN文档: 随便Baidu，最重要的是自己动手
- 教程项目源码： https://github.com/fluent-qa/qabox-tutorials/tree/main/fluentqa-java-tutorials
- 数据库搭建： postgresql， docker

## 起点

本系列文章只针对一个假设，就是突然有一天老板说你看外面好多做测试平台的，我们可以自己引入一个或者自己做一个来表示我们测试的能力吗？
至于做什么吗，可以围绕下面几个方面考虑：

1. 自动化测试
2. 测试用例管理
3. 测试需求管理
4. 测试执行管理
5. 测试环境管理
6. 应该还有好多好多，你可以结合实际情况自己想想

主要呢就是能够提高效率，展示能力， 你去看看可不可以？或者你先去调研下？

自然你会做一些调研,然后你会和老板说：
1. metershpere可以直接用
2. 还有好多开源的也可以直接搭建

老板可能就同意了，那就用开源的了，大家都开心，那么这系列文章大体你也不感兴趣了.
如果老板说，最好我们自己做吧(抄也好),我们就自己做一下，也当展示和锻炼下我们能力. 然后其实可能你们组也就几个人，忙着业务测试，忙着上线，真的没太多时间做这个，
那么或许下面这一些文章可能对你有点帮助，不需要花费太多精力就能做一个看起来是那么一回事的测试管理平台,而从中你也能获得一些收获比如：
1. 使用了一门语言JAVA，了解了框架SpringBoot，springboot-data-jpa
2. 做了一个后台管理系统,说不定哪天有人给个外包的活，你也能接一下
3. 不需要花费太多成本，可以交差，也可以让你老板对你高看一眼，看起来你还挺能干的

好了，废话阶段结束，直接开始动手干活吧.

## 搭建项目开始

- 一行代码，常规配置，就能看到一个后台管理页面

```java
package io.fluentqa.workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import xyz.erupt.core.annotation.EruptScan;

@SpringBootApplication
@EnableAsync
@EruptScan(value = {"io.fluentqa"})
@EntityScan(value = {"io.fluentqa"})
public class QAWorkspaceApp {
    public static void main(String[] args) {
        SpringApplication.run(QAWorkspaceApp.class);
    }
}

```




