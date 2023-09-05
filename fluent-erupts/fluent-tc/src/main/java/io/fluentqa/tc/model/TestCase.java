package io.fluentqa.tc.model;

import io.fluentqa.erupts.base.handlers.SqlTagFetchHandler;
import io.fluentqa.erupts.base.model.ModelWithValidFlagVo;
import io.fluentqa.pm.product.model.ProductModuleValidFlagVo;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 */
@Data
@Entity
@Erupt(name = "测试用例",
        power = @Power(export = true),
        orderBy = "TestCase.updateTime desc",
        linkTree = @LinkTree(field = "product"))
@Table(name = "test_cases")
public class TestCase extends ModelWithValidFlagVo {

    @EruptField(
            views = @View(
                    title = "功能点"
            ),
            edit = @Edit(
                    title = "功能点",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String feature;

    @EruptField(
            views = @View(
                    title = "用例描述"
            ),
            edit = @Edit(
                    title = "用例描述",
                    type = EditType.INPUT, notNull = true
            )
    )
    private String summary;

    @EruptField(
            views = @View(
                    title = "用例优先级"
            ),
            edit = @Edit(
                    title = "用例优先级",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String priority = "P2"; //check it
    @EruptField(
            views = @View(
                    title = "用例前提条件"
            ),
            edit = @Edit(
                    title = "用例优先级",
                    type = EditType.INPUT
            )
    )
    private String precondition;
    @EruptField(
            views = @View(
                    title = "测试步骤"
            ),
            edit = @Edit(
                    title = "测试步骤",
                    type = EditType.CODE_EDITOR, notNull = true,
                    codeEditType = @CodeEditorType(language = "text")
            )
    )
    private String steps;
    @EruptField(
            views = @View(
                    title = "用例期望结果"
            ),
            edit = @Edit(
                    title = "用例期望结果",
                    type = EditType.CODE_EDITOR, notNull = true,
                    codeEditType = @CodeEditorType(language = "text")
            )
    )
    private String expectedResult;
}
