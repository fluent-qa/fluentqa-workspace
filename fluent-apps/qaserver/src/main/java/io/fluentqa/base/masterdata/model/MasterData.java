package io.fluentqa.base.masterdata.model;

import io.fluentqa.base.handlers.SqlTagFetchHandler;
import io.fluentqa.base.model.ModelWithValidFlagVo;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.TagsType;

import javax.persistence.Entity;
import javax.persistence.Table;


@Erupt(name = "产品字典值配置", power = @Power(importable = true, export = true))
@Table(name = "master_data")
@Entity
@Data
public class MasterData extends ModelWithValidFlagVo {

    @EruptField(
            views = @View(title = "分类"),
            edit = @Edit(
                    search = @Search(vague = true),
                    title = "获取可选种类",
                    type = EditType.TAGS,
                    desc = "动态获取可选种类",
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct category from master_data where valid=true"
                    ))
    )
    private String category;

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
                    title = "详细描述"
            ),
            edit = @Edit(
                    title = "详细描述",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String detail;

    @EruptField(
            views = @View(
                    title = "代号"
            ),
            edit = @Edit(
                    title = "代号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String code;

}