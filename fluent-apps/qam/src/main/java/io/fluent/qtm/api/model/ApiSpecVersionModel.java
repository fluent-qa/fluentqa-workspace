package io.fluent.qtm.api.model;

import io.fluent.base.model.ModelWithValidFlagVo;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "api_spec_version")
@Erupt(
        name = "远程服务原始文件",
        power = @Power(export = true),
        layout = @Layout(
                tableLeftFixed = 3,
                pageSize = 30)
)
@Data
@SQLDelete(sql = "update api_spec_version set valid=false where id=?")
@Where(clause = "valid = true")
public class ApiSpecVersionModel extends ModelWithValidFlagVo {
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
                    title = "名称"
            ),
            edit = @Edit(
                    title = "名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String type="POSTMAN";

    @EruptField(
            views = @View(
                    title = "服务类型"
            ),
            edit = @Edit(
                    title = "服务类型",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String serviceType; //API or RPC

    @EruptField(
            views = @View(
                    title = "版本"
            ),
            edit = @Edit(
                    title = "版本",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String appVersion;

    @EruptField(
            views = @View(title = "GIT URL")
    )
    private String gitUrl;
    @EruptField(
            views = @View(title = "GIT分支")
    )
    private String branch;

    @EruptField(
            views = @View(title = "接口定义", type = ViewType.CODE),
            edit = @Edit(title = "接口定义", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String spec;
}