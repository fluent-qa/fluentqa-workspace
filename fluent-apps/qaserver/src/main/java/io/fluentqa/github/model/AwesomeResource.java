package io.fluentqa.github.model;

import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.Entity;

@Data
@Entity
@Erupt(name = "Awesome Resource", power = @Power(importable = true, export = true))
public class AwesomeResource extends MetaModel {
    @EruptField(views = @View(title = "名称"), edit = @Edit(title = "名称", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String name;
    @EruptField(views = @View(title = "URL"), edit = @Edit(title = "URL", type = EditType.TEXTAREA,
            search = @Search, notNull = true, inputType = @InputType))
    private String url;

    @EruptField(views = @View(title = "content"), edit = @Edit(title = "content", type = EditType.HTML_EDITOR,
            search = @Search, notNull = true, inputType = @InputType))
    private String content;
}
