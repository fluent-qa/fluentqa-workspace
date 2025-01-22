package io.fluent.github.model;

import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.MetaModelVo;

import javax.persistence.Entity;

@Data
@Entity
@Erupt(name = "starred Github Repos",
        power = @Power(importable = true, export = true), layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30))
public class GithubStarredRepo extends MetaModelVo {
    @EruptField(views = @View(title = "名称"), edit = @Edit(title = "名称", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String name;
    @EruptField(views = @View(title = "htmlUrl"), edit = @Edit(title = "htmlUrl", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String htmlUrl;
    @EruptField(views = @View(title = "URL"), edit = @Edit(title = "URL", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String url;

    @EruptField(views = @View(title = "全名"), edit = @Edit(title = "全名", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String fullName;

    private String nodeId;
    @EruptField(views = @View(title = "描述"), edit = @Edit(title = "描述", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String description;
    @EruptField(views = @View(title = "fork数量"), edit = @Edit(title = "fork数量", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private int forksCount;
    @EruptField(views = @View(title = "star数量"), edit = @Edit(title = "star数量", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private int stargazersCount;


    @EruptField(views = @View(title = "主题"), edit = @Edit(title = "主题", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String topics;

    @EruptField(views = @View(title = "语言"), edit = @Edit(title = "语言", type = EditType.INPUT, search = @Search, notNull = true, inputType = @InputType))
    private String language;
}
