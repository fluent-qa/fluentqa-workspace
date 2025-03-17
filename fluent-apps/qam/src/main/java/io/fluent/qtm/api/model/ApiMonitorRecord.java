package io.fluent.qtm.api.model;


import io.fluent.qtm.api.handler.GenerateApiCaseByCaptureDataHandler;
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
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.TagsType;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "api_monitor_record")
@Erupt(
        name = "接口访问记录",
        layout = @Layout(
                tableLeftFixed = 3,
                pageSize = 30),
        power = @Power(importable = true, export = true),
        rowOperation = {@RowOperation(
                title = "生成接口用例数据",
                operationHandler = GenerateApiCaseByCaptureDataHandler.class)},
        orderBy = "ApiMonitorRecord.id desc"

)
@Data
public class ApiMonitorRecord extends MetaModel {

    @EruptField(
            views = @View(title = "app"),
            edit = @Edit(
                    title = "app应用名",
                    type = EditType.TAGS, search = @Search(vague = true), notNull = true,
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct app from api_monitor_record"
                    )
            ))
    private String app;
    @EruptField(
            views = @View(title = "录制名称"),
            edit = @Edit(title = "录制名称", notNull = true, search = @Search)
    )
    private String recordName;
    @EruptField(
            views = @View(title = "请求地址"),
            edit = @Edit(title = "请求地址", notNull = true, search = @Search)
    )
    private String requestUrl;

    @EruptField(
            views = @View(title = "服务"),
            edit = @Edit(
                    title = "服务",
                    type = EditType.TAGS, search = @Search(vague = true), notNull = true,
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct service from api_monitor_record"
                    )
            )
    )

    private String service;
    @EruptField(
            views = @View(title = "接口名称"),
            edit = @Edit(title = "接口名称", notNull = true, search = @Search)
    )
    private String api;

    @EruptField(
            views = @View(title = "服务URL"),
            edit = @Edit(title = "服务URL", notNull = true, search = @Search)
    )
    private String path;

    @EruptField(
            views = @View(title = "请求头"),
            edit = @Edit(title = "请求报文", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String requestHeaders;

    @EruptField(
            views = @View(title = "HTTP方法"),
            edit = @Edit(title = "HTTP方法", notNull = true, search = @Search)
    )
    private String method;

    @EruptField(
            views = @View(title = "请求报文", type = ViewType.CODE),
            edit = @Edit(title = "请求报文", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String requestBody;


    @EruptField(
            views = @View(title = "response_headers"),
            edit = @Edit(title = "responseHeaders", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String responseHeaders;

    @EruptField(
            views = @View(title = "status_code"),
            edit = @Edit(title = "status_code", notNull = true, search = @Search)
    )
    private int statusCode;

    @EruptField(
            views = @View(title = "返回报文", type = ViewType.CODE),
            edit = @Edit(title = "返回报文", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String responseBody;



}
