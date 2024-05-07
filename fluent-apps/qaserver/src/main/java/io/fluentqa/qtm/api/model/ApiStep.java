package io.fluentqa.qtm.api.model;

import io.fluentqa.base.handlers.SqlTagFetchHandler;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.TagsType;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "api_steps")
@Erupt(
        name = "接口测试用例", layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30), power = @Power(importable = true, export = true),
        orderBy = "ApiTestStep.updateTime desc"
)
public class ApiStep extends MetaModel{

    @EruptField(
            views = @View(title = "场景"),
            edit = @Edit(title = "场景", notNull = true, search = @Search)
    )
    private String scenario;

    @EruptField(
            views = @View(title = "用例名称"),
            edit = @Edit(title = "用例名称", notNull = true, search = @Search)
    )
    private String caseName;

    @EruptField(
            views = @View(title = "服务"),
            edit = @Edit(
                    search = @Search,
                    title = "获取可选服务",
                    type = EditType.TAGS,
                    desc = "获取可选服务",
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct service_name from remote_services where type='API' and valid=true"
                    ))
    )
    private String serviceName;
    @EruptField(
            views = @View(title = "服务方法"),
            edit = @Edit(title = "服务方法", notNull = true, search = @Search)
    )
    private String serviceMethod;

    @EruptField(
            views = @View(title = "接口路径"),
            edit = @Edit(title = "接口路径", notNull = true, search = @Search)
    )
    private String path;

    @EruptField(
//            views = @View(title = "测试请求", type = ViewType.CODE),
            edit = @Edit(title = "测试请求", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String request;
    @EruptField(
//            views = @View(title = "接口请求结果"),
            edit = @Edit(title = "接口请求结果",
                    type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String result;


    @EruptField(
//            views = @View(title = "预期结果"),
            edit = @Edit(title = "预期结果", notNull = true, type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "json"))
    )
    private String expect;


    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceMethod() {
        return serviceMethod;
    }

    public void setServiceMethod(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }
}
