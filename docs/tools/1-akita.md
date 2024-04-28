# Akita

[akita](https://docs.akita.software/docs/how-akita-works)
> Akita watches your API traffic for automatic discovery and dashboards

根据提供的文档《How Akita Works》，以下是Akita软件的要点总结：

1. **API流量监控**：Akita通过使用eBPF技术自动发现API流量，并为监控和仪表板生成数据。

2. **低摩擦部署**：Akita代理（Agent）可以无摩擦地部署，不需要通过SDK提供访问权限，也不需要更改代码或代理。

3. **低风险部署**：Akita代理在服务器上运行，仅将请求/响应的元数据发送回云端，确保敏感数据不会暴露给Akita服务器。

4. **自动API行为建模**：Akita自动对API流量进行建模，推断API路径，为每个端点提供监控和警报功能。

5. **流量分析技术**：Akita代理使用salted hash对有效载荷数据进行加密，并且永远不会解密（unhash），确保敏感数据不会被Akita云服务看到。

6. **高级流量分析算法**：Akita云使用先进的流量分析算法自动推断端点结构（包括路径参数）、数据类型、认证等，减少了编写API规范或制作仪表板的工作。

7. **数据访问和处理政策**：Akita有明确的数据访问和处理政策，确保用户数据的安全性和隐私性。

8. **支持的技术栈**：Akita支持多种技术栈，以适应不同的部署环境和需求。

## How to Run

```shell
docker pull public.ecr.aws/akitasoftware/akita-cli:latest
```

start agent
```shell
docker run --rm --network host
  -e AKITA_API_KEY_ID= API KEY ID \
  -e AKITA_API_KEY_SECRET= API KEY SECRET \
  akitasoftware/cli:latest apidump \
  --project PROJECT NAME
```

## codes

- [akita-cli](https://github.com/akitasoftware/akita-cli)
- [akita-libs](https://github.com/akitasoftware/akita-libs.git)
