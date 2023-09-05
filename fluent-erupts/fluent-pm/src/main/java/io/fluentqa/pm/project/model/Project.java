package io.fluentqa.pm.project.model;


import io.fluentqa.erupts.base.model.ModelWithValidFlagVo;
import io.fluentqa.pm.product.model.Product;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.toolkit.handler.SqlChoiceFetchHandler;

import javax.persistence.*;
import java.util.UUID;

@Erupt(name = "项目",
        power = @Power(importable = true, export = true),
        tree = @Tree(pid = "parent.id"))
@Entity
@Table(name = "projects")
@Data
public class Project extends ModelWithValidFlagVo {

    @EruptField(
            views = @View(
                    title = "名称"
            ),
            edit = @Edit(
                    title = "名称",
                    type = EditType.INPUT, search = @Search,
                    notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "代号"
            ),
            edit = @Edit(
                    title = "代号",
                    type = EditType.INPUT, search = @Search,
                    notNull = true,
                    inputType = @InputType
            )
    )
    private String code;

    @EruptField(
            views = @View(
                    title = "详细描述"
            ),
            edit = @Edit(
                    title = "详细描述",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String details;

    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "产品列表",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private Product productId;

    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "上级树节点",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private Project parent;

    @Column(length = 36, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();
}