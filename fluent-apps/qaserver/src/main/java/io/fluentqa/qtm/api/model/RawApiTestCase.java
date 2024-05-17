package io.fluentqa.qtm.api.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.Entity;
import javax.persistence.Table;


@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "raw_api_cases")
@Erupt(
        name = "接口测试用例生成", layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30), power = @Power(importable = true, export = true),
        orderBy = "RawApiTestCase.createTime "
)
@Data
public class RawApiTestCase extends MetaModel{
    @EruptField(
            views = @View(title = "测试场景"),
            edit = @Edit(title = "测试场景", search = @Search)
    )
    private String scenario;

    @EruptField(
            views = @View(title = "服务名称"),
            edit = @Edit(title = "服务名称", notNull = true, search = @Search)
    )
    private String serviceName;

    @EruptField(
            views = @View(title = "API接口"),
            edit = @Edit(title = "API接口", notNull = true, search = @Search)
    )
    private String serviceMethod;

    @EruptField(
            views = @View(title = "用例名称"),
            edit = @Edit(title = "用例名称", notNull = true, search = @Search)
    )
    private String name;

    @EruptField(
            views = @View(title = "请求路径"),
            edit = @Edit(title = "请求路径", notNull = true, search = @Search)
    )
    private String uri;

    @EruptField(
            views = @View(title = "请求方法"),
            edit = @Edit(title = "请求方法", notNull = true)
    )
    private String method = "POST";

    @EruptField(
            views = @View(title = "输入", type = ViewType.CODE),
            edit = @Edit(title = "输入",
                    type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String input;

    @EruptField(
            views = @View(title = "期望结果", type = ViewType.CODE),
            edit = @Edit(title = "期望结果", type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "json"))
    )
    private String expected;

    @EruptField(
            views = @View(title = "优先级"),
            edit = @Edit(title = "优先级")
    )
    private String priority = "P1";

    @EruptField(
            views = @View(title = "是否运行"),
            edit = @Edit(title = "是否运行")
    )
    private boolean isRun = true;

}
