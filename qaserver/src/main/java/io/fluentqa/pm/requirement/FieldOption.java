package io.fluentqa.pm.requirement;


import io.fluentqa.base.model.ModelWithValidFlag;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.fun.ChoiceFetchHandler;
import xyz.erupt.annotation.fun.VLModel;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Erupt(name = "字段选项",
        power = @Power(export = true, importable = true),
        orderBy = "FieldOption.updateTime desc")
@Table(name = "field_option")
public class FieldOption extends ModelWithValidFlag implements ChoiceFetchHandler {
    @EruptField(
            views = @View(
                    title = "名称"
            ),
            edit = @Edit(
                    title = "名称",notNull = true
            )
    )
    private String name;
    @EruptField(
            views = @View(
                    title = "字段code"
            ),
            edit = @Edit(
                    title = "字段code"
            )
    )
    private String code;

    @EruptField(
            views = @View(title = "编辑类型"),
            edit = @Edit(title = "编辑类型",
                    notNull = true, type = EditType.CHOICE,
                    choiceType = @ChoiceType(type = ChoiceType.Type.RADIO, fetchHandler = FieldOption.class))
    )
    private String type;

    @EruptField(
            views = @View(
                    title = "是否可以为空"
            ),
            edit = @Edit(
                    title = "是否可以为空",
                    type = EditType.BOOLEAN
            )
    )
    private boolean notNull;
    @EruptField(
            views = @View(
                    title = "字段约束条件"
            ),
            edit = @Edit(
                    title = "字段约束条件",
                    type = EditType.CODE_EDITOR, notNull = true,
                    codeEditType = @CodeEditorType(language = "text"),
                    desc = "字段约束条件"
            )
    )
    private String constrains;

    @EruptField(
            views = @View(
                    title = "和其他业务关系"
            ),
            edit = @Edit(
                    title = "和其他业务关系",
                    type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "text")
            )
    )
    private String relatedTo;

    @EruptField(
            views = @View(title = "显示顺序", sortable = true),
            edit = @Edit(title = "显示顺序", notNull = true)
    )
    private Integer sort;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public String getConstrains() {
        return constrains;
    }

    public void setConstrains(String constrains) {
        this.constrains = constrains;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public List<VLModel> fetch(String[] params) {
        List<VLModel> list = new ArrayList<>();
        for (FieldOptionType value : FieldOptionType.values()) {
            list.add(new VLModel(value.name(), value.getDesc()));
        }
        return list;
    }
}
