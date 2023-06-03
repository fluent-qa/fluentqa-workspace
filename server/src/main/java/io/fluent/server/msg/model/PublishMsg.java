package io.fluent.server.msg.model;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "publish_msg")
@Erupt(
        name = "发布消息", power = @Power(importable = true, export = true),
        orderBy = "PublishMsg.id desc"

)
@Data
public class PublishMsg extends MetaModel {

    @EruptField(
            views = @View(title = "地址"),
            edit = @Edit(title = "地址", notNull = true, search = @Search)
    )
    private String address;
    @EruptField(
            views = @View(title = "话题"),
            edit = @Edit(title = "话题", notNull = true, search = @Search)
    )
    private String topic;
    @EruptField(
            views = @View(title = "内容"),
            edit = @Edit(title = "内容", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String msg;

    @EruptField(
            views = @View(title = "状态"),
            edit = @Edit(title = "状态", notNull = true, search = @Search)
    )
    private boolean status;

}
