package io.fluentqa.erupts.base.model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@DynamicUpdate
@DynamicInsert
@Where(clause = "valid=true")
public class NamedModelVO extends ModelWithValidFlagVo {
    @EruptField(
            views = @View(
                    title = "名称", sortable = true
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
                    title = "详细描述", sortable = true
            ),
            edit = @Edit(
                    title = "详细描述",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
