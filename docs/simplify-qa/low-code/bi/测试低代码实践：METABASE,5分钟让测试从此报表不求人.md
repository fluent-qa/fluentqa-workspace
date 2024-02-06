
>5分钟让你报表不求人

2023年尝试了不少低代码工具,我自己的结论是，组合使用这些工具会让你的效率大大提升，比如说这款metabase，或许之花个5分钟-30分钟就可以让你从此表报不求人，前后端通吃了. 不说夸张的话，感兴趣自己试试就可以.

[metabase](https://www.metabase.com/docs/latest/)

>Don't be a bottleneck
Fast analytics with the friendly UX and integrated tooling to let your company explore data on their own.

测试同学日常如果需要统计一些数据和做一些DASHBOARD,来做一些数据分析，Metabase 可以满足大部分的需求. 当然前提是数据已经落到数据库，那么日常统计如：

1. Bug数量
2. 测试进度
3. 接口测试覆盖率
4. 测试用例完成度
等等事情就是小菜一碟，异常轻松. 如果想要在内部系统中集成这个Dashboard通过iframe嵌入就可以.

用这个方法的最大好处是：
1. 足够简单,有SQL基础，1个小时入门使用吧
2. 不需要开发任何代码,不需要前端后端开发，一个人都能搞定
3. 随时随地修改，随时随地集成到现有系统

下面用几个例子来说明一下Metabase可以做什么,使用这个希望老板再叫你做一个报表展示系统，不用太担心什么前后端开发的事情了.

## 1. 安装

一条命令即可:

```sh
docker run -d -p 3000:3000 --name metabase metabase/metabase -v ~/metabase-data:/metabase-data 
```

## 2. 第一个图表-饼图

假设目前你已经有所以API信息，你想统计一下API分模块的数量，用饼图展示，需要怎么做呢？

假设API信息都在表```apis``` 这个表里面，那么只需要在Metabase中创建SQL查询，同时可视化视图中选择饼图就可以：

![[metabase-pie.png]]
## 3. 第一个Dashboard

在创建了第一个饼图之后,可以将此饼图添加到一个Dashboard中，
![[metabase-add-chart.png]]
这样第一个Dashboard也已经做好，如果想要往这个Dashboard中添加更多的内容，可以先去常见一个查询/问题，选择可视化之后，在加入到Dashboard中就可以
加入后的效果如下:
![[api-dashboard.png]]
## 4. 进阶

以上两个例子是最简单的Metabase使用小结，还有一些高级的用法：
1. 交互式图表，就是可以有参数选择进行筛选
2. 不同图表进行跳转
3. 各种不同的图表类型使用

![[metabase-charts.png]]

## 5. 集成

如何将这些报表集成到已有系统或者老板想任何时候都能看到的话，Metabase有分享功能，可以通过iframe直接嵌入到已有系统:
![[metabase-share.png]]
这样一个报表系统就这么完成了，完全可以满足日常QA使用，只要去解决数据落库的问题，一个日常测试的指标Dashboard就可以非常方便的构建，同时有很多灵活度，因为Dashboard可以随时构建，缺的只是合适的数据.

![微信公众号发布](https://mp.weixin.qq.com/s?__biz=MzIxMzgzNjA3NA==&mid=2247484211&idx=1&sn=dbbfc1e4c4ee1fcd9dc4fe7212c04da4&chksm=97b18b76a0c6026057fd4589ca5e045d9aac5187aff4057afafa4bd2de970fae919f9d11c39a&token=1054280431&lang=zh_CN#rd)

