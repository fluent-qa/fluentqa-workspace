package io.fluent.qtm.api.model;

import cn.hutool.core.lang.UUID;
import io.fluent.qtm.api.handler.GenerateRawApiCaseHandler;
import io.fluent.base.handlers.SqlTagFetchHandler;
import io.fluent.base.model.ModelWithValidFlag;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_erupt.RowOperation;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.toolkit.handler.SqlChoiceFetchHandler;

import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "remote_services")
@Erupt(
        name = "远程服务清单", layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30),
        power = @Power(export = true),
        rowOperation = {@RowOperation(
                title = "生成原始接口用例",
                operationHandler = GenerateRawApiCaseHandler.class)}
)
@Data
@SQLDelete(sql = "update remote_services set valid=false where id=?")
@Where(clause = "valid = true")
public class RemoteApi extends ModelWithValidFlag {
    @EruptField(
            views = @View(
                    title = "名称"
            ),
            edit = @Edit(
                    title = "名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "产品"
            ),
            edit = @Edit(
                    title = "产品",
                    type = EditType.CHOICE,
                    desc = "获取产品",
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            fetchHandlerParams = "select id,name,details from products where valid =true and parent_id is NULL"
                    ))
    )
    private Long productId;

    @EruptField(
            views = @View(title = "模块名"),
            edit = @Edit(
                    search = @Search,
                    title = "获取可选模块",
                    type = EditType.TAGS,
                    desc = "动态获取可选模块",
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct module_name from remote_services where valid=true"
                    ))
    )
    private String moduleName;

    @EruptField(
            views = @View(title = "服务"),
            edit = @Edit(
                    search = @Search,
                    title = "获取可选服务",
                    type = EditType.TAGS,
                    desc = "获取可选服务",
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct service_name from remote_services where valid=true"
                    ))
    )
    private String serviceName;

    @EruptField(
            views = @View(title = "地址"),
            edit = @Edit(title = "地址", notNull = true)
    )
    private String endpoint;

    @EruptField(
            views = @View(title = "方法"),
            edit = @Edit(title = "方法", notNull = true, search = @Search)
    )
    private String serviceMethod;

    @EruptField(
            views = @View(title = "http请求方法"),
            edit = @Edit(title = "http请求方法", notNull = true)
    )
    private String httpMethod;

    @EruptField(
            views = @View(title = "请求报文", type = ViewType.CODE),
            edit = @Edit(title = "请求报文", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String body;

    @EruptField(
            views = @View(title = "接口类型"),
            edit = @Edit(title = "接口类型", search = @Search,
                    type = EditType.CHOICE, choiceType = @ChoiceType(
                    vl = {@VL(value = "API", label = "API"), @VL(value = "RPC", label = "RPC")}
            ))
    )
    private String type;

    @EruptField(
            views = @View(title = "服务使用状态"),
            edit = @Edit(title = "服务使用状态",
                    search = @Search, notNull = true,
                    type = EditType.CHOICE, choiceType = @ChoiceType(
                    vl = {@VL(value = "NEW", label = "新增"),
                            @VL(value = "IN_USE", label = "使用中"),
                            @VL(value = "UPDATE", label = "更新"),
                            @VL(value = "END_OF_LIFE", label = "已作废"),})))
    private String status;

    @EruptField(
            views = @View(
                    title = "引入时版本"
            ),
            edit = @Edit(
                    title = "引入时版本",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String addedVersion;

    @EruptField(
            views = @View(
                    title = "最新版本"
            ),
            edit = @Edit(
                    title = "最新版本",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String latestVersion;

    @EruptField(
            views = @View(show = false, title = "uid")
    )
    private String uId = UUID.fastUUID().toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getServiceMethod() {
        return serviceMethod;
    }

    public void setServiceMethod(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddedVersion() {
        return addedVersion;
    }

    public void setAddedVersion(String addedVersion) {
        this.addedVersion = addedVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}