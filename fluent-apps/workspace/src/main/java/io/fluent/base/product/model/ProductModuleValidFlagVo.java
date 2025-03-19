package io.fluent.base.product.model;

import io.fluent.base.model.ModelWithValidFlagVo;
import lombok.Getter;
import lombok.Setter;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class ProductModuleValidFlagVo extends ModelWithValidFlagVo {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @EruptField(
            views = @View(title = "产品名称",column = "details"),
            edit = @Edit(
                    search = @Search,
                    title = "产品选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态获取产品",
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name",
                            pid = "parent.id"))
    )
    private ProductModuleModel product;

    @ManyToOne
    @JoinColumn(name = "module_id")
    @EruptField(
            views = @View(title = "模块名称",column = "details"),
            edit = @Edit(title = "模块选择", search = @Search, type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name",
                            dependField = "product",
                            dependColumn = "parent.id"
                    ))
    )
    private ProductModuleModel module;

}
