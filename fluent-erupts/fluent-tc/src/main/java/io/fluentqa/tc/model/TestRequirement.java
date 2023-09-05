package io.fluentqa.tc.model;

import io.fluentqa.erupts.base.model.NamedTimeStatusModel;
import io.fluentqa.pm.product.model.Product;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//TODO: Filter By Status
//TODO: input by Uploaded File or File Sync
@Data
@Entity
@Table(name ="requirements")
@Erupt(name = "测试需求管理",
        power = @Power(importable = true, export = true),
        tree = @Tree(pid = "parent.id"))
public class TestRequirement extends NamedTimeStatusModel {
    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "上级需求",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private TestRequirement parent;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EruptField(
            views = @View(title = "产品名称",column = "name"),
            edit = @Edit(
                    search = @Search,
                    title = "产品选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态获取产品",
                    referenceTreeType = @ReferenceTreeType(
                            pid = "parent.id"))
    )
    private Product product;

    @EruptField(
            views = @View(
                    title = "测试负责人"
            ),
            edit = @Edit(
                    title = "测试负责人",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String testOwner;

    @EruptField(
            views = @View(
                    title = "产品负责人"
            ),
            edit = @Edit(
                    title = "产品负责人",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String productOwner;

}
