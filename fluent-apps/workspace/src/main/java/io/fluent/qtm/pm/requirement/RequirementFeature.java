package io.fluent.qtm.pm.requirement;

import io.fluent.base.model.ModelWithValidFlag;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Erupt(name = "需求功能点",
        power = @Power(export = true, importable = true),
        orderBy = "RequirementFeature.updateTime desc")
@Table(name = "requirement_features")
public class RequirementFeature extends ModelWithValidFlag  {

    @EruptField(
            views = @View(
                    title = "业务功能相关说明"
            ),
            edit = @Edit(
                    title = "业务功能相关说明",
                    type = EditType.CODE_EDITOR, notNull = true,
                    codeEditType = @CodeEditorType(language = "text")
            )
    )
    private String feature;

}
