package io.fluent.qtm.api.model;

import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "apispec_git_repo")
@Data
@Erupt(name = "skel仓库设置",     layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30),
        power = @Power(importable = true, export = true))
public class ApiSpecGitRepoModel extends MetaModel {
    @EruptField(
            views = @View(title = "应用名-appName"),
            edit = @Edit(title = "应用名-App Name", notNull = true, search = @Search)
    )
    private String name;
    @EruptField(
            views = @View(title = "gitUrl"),
            edit = @Edit(title = "gitUrl", notNull = true)
    )
    private String gitUrl;

    @EruptField(
            views = @View(title = "gitlabId"),
            edit = @Edit(title = "gitlabId", notNull = true)
    )
    private Integer gitlabId;

    @EruptField(
            views = @View(title = "webUrl"),
            edit = @Edit(title = "webUrl", notNull = true)
    )
    private String webUrl;

}
