package io.fluent.qtm.api.model;

import io.fluent.qtm.api.handler.GenerateApiTestStepByApiTestRecord;
import io.fluent.base.handlers.SqlTagFetchHandler;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_erupt.RowOperation;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.TagsType;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 1. 原先的表结构设计几个问题:
 * - 没有办法区分那次测试运行记录
 * - 查找不太方便
 * - name 和service name 重复，没有必要同时使用
 * - serviceName 从remote service里面取不过滤API，不够精确
 * 修改方式:
 * - name 修改为测试用例运行名称
 * - serviceName 取tags 从remote service 的API 中取
 */
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "api_test_record")
@Erupt(
        name = "接口测试结果", layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30), power = @Power(importable = true, export = true),
        orderBy = "ApiTestRecord.id desc",
        rowOperation = {@RowOperation(
                title = "生成可用测试步骤",
                operationHandler = GenerateApiTestStepByApiTestRecord.class)}
)
@Data
public class ApiTestRecord extends MetaModel {
    @EruptField(
            views = @View(title = "测试运行名称"),
            edit = @Edit(title = "name", search = @Search)
    )
    private String name;

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
            views = @View(title = "状态码"),
            edit = @Edit(title = "状态码", notNull = true, search = @Search)
    )
    private String statusCode;

    @EruptField(
            views = @View(title = "错误日志"),
            edit = @Edit(title = "错误日志",
                    type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String errorLog;

    @EruptField(
//            views = @View(title = "预期结果"),
            edit = @Edit(title = "预期结果", notNull = true, type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "json"))
    )
    private String expect;

    //TODO: 通过或者失败
    @EruptField(
            views = @View(title = "用例执行结果"),
            edit = @Edit(title = "用例执行结果", search = @Search)
    )
    private boolean isSuccess;

}
