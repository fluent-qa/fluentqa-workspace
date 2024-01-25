package io.fluentqa.qtm.api.service;

import cn.hutool.core.bean.BeanUtil;
import io.fluent.postman.PostmanParser;
import io.fluent.postman.model.PostmanCollection;
import io.fluent.postman.model.PostmanItem;
import io.fluentqa.qtm.api.model.ApiSpecVersionModel;
import io.fluentqa.qtm.api.model.RemoteApi;
import io.fluentqa.qtm.api.model.RemoteApiStatus;
import io.fluentqa.qtm.api.repo.RemoteServiceRepo;
import io.fluentqa.qtm.pm.product.model.ProductModuleModel;
import io.fluentqa.qtm.pm.product.service.ProductModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RemoteApiService {

    @Autowired
    private ProductModuleService productMetaService;

    @Autowired
    private RemoteServiceRepo remoteServiceRepo;


    /**
     * 1. 解析postman 文件
     * 2. 确认接口是
     * - 新增:NEW： 当前记录无记录，则更新
     * - 更新:UPDATED: 当前记录中有记录,但是接口定义发生变化，比如请求内容
     * - 使用中,IN_USE:
     * - 移除:END_OF_LIFE: 接口不在最新清单中
     * 3.
     *
     * @param apiSpec
     */
    @Transactional
    public void apiSpecToApiList(ApiSpecVersionModel apiSpec, String updater) {
        ProductModuleModel productMeta = productMetaService.createApiModuleIfNotExist(apiSpec.getName(), updater);
        if (apiSpec.getSpec().isEmpty()) return;
        PostmanCollection collection = PostmanParser.create().toPostmanCollection(apiSpec.getSpec());
        for (PostmanItem postmanItem : collection.getItem()) {
            for (PostmanItem item : postmanItem.getItem()) {
                RemoteApi rs = toRemoteApi(apiSpec, productMeta, postmanItem, item);
                createOrUpdateRemoteApi(rs, apiSpec);
            }
            updateStatusToEndOfLife(apiSpec, postmanItem);
        }
    }

    @Transactional
    public void apiSpecsToApiList(List<ApiSpecVersionModel> apiSpecs, String updater) {
        for (ApiSpecVersionModel apiSpec : apiSpecs) {
            try {
                this.apiSpecToApiList(apiSpec, updater);
            } catch (Exception e) {
                log.error("%s-api-failed,error=%s".formatted(
                        apiSpec.getName(), e.getMessage()
                ));
            }
        }
    }

    private RemoteApi toRemoteApi(ApiSpecVersionModel apiSpec, ProductModuleModel productMeta,
                                  PostmanItem postmanItem, PostmanItem item) {
        RemoteApi rs = new RemoteApi();
        rs.setName(item.getName());
        rs.setServiceName(postmanItem.getName());
        rs.setServiceMethod(item.getName());
        rs.setBody(item.getRequest().getBody().get("raw").toString());
        rs.setHttpMethod(item.getRequest().getMethod());
        rs.setEndpoint(item.getRequest().getUrl().getRaw());
        rs.setType(apiSpec.getServiceType());
        rs.setModuleName(apiSpec.getName());
        rs.setProductId(productMeta.getParent().getId());
        return rs;
    }

    /**
     * create or update 基本可以使用同一种方式处理
     * 1. 输入实体
     * 2. 字段检验规则
     * 3. 判断重复确认条件
     * 4. 更新字段处理，保存记录
     * TODO: try to integrate with Feishu
     *
     * @param newApi
     */
    public void createOrUpdateRemoteApi(RemoteApi newApi, ApiSpecVersionModel apiSpec) {
        Optional<RemoteApi> api = remoteServiceRepo.findRemoteApiByEndpointAndServiceNameAndServiceMethod(
                newApi.getEndpoint(),
                newApi.getServiceName(),
                newApi.getServiceMethod());
        if (api.isEmpty()) {
            newApi.setStatus(RemoteApiStatus.NEW.toString());
            newApi.setAddedVersion(apiSpec.getAppVersion());
            newApi.setLatestVersion(apiSpec.getAppVersion());
            remoteServiceRepo.save(newApi);
        } else {
            RemoteApi existApi = api.get();
            BeanUtil.copyProperties(newApi, existApi, "id");
            //TODO: 如何确认接口变更-暂时不确认
            if (existApi.getBody().equalsIgnoreCase(newApi.getBody())) {
                existApi.setStatus(RemoteApiStatus.IN_USE.toString());
                existApi.setLatestVersion(apiSpec.getAppVersion());
            } else {
                existApi.setStatus(RemoteApiStatus.UPDATED.toString());
                existApi.setLatestVersion(apiSpec.getAppVersion());
            }
            remoteServiceRepo.save(existApi);
        }
    }

    public void updateStatusToEndOfLife(ApiSpecVersionModel apiSpec, PostmanItem postmanItem) {
        Optional<List<RemoteApi>> apiListOptional = remoteServiceRepo.findRemoteApiByModuleNameAndServiceNameAndLatestVersionNot(
                apiSpec.getName(),
                postmanItem.getName(),
                apiSpec.getAppVersion()
        );
        if (apiListOptional.isEmpty()) {
            log.info("没有需要删除的数据");
        } else {
            List<RemoteApi> apiList = apiListOptional.get();
            for (RemoteApi api : apiList) {
                api.setStatus(RemoteApiStatus.END_OF_LIFE.toString());
                remoteServiceRepo.save(api);
                log.info("有需要删除的数据");
            }

        }
    }


}


