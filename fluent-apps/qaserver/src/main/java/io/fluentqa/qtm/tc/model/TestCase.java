package io.fluentqa.qtm.tc.model;

import io.fluentqa.base.handlers.SqlTagFetchHandler;
import io.fluentqa.base.model.ModelWithValidFlagVo;
import io.fluentqa.base.product.model.ProductModuleModel;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Erupt(name = "测试用例",
        power = @Power(export = true),
        orderBy = "TestCase.updateTime desc",
        linkTree = @LinkTree(field = "module"),layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30))
@Table(name = "test_cases")
public class TestCase extends ModelWithValidFlagVo {

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EruptField(
            views = @View(title = "所属模块",column = "details"),
            edit = @Edit(
                    notNull = true,
                    search = @Search,
                    title = "产品模块选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态获取产品",
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name",
                            pid = "parent.id"))
    )
    private ProductModuleModel module;

    @ManyToOne
    @JoinColumn(name = "parent_product_id")
    @EruptField(
            views = @View(title = "父模块",column = "details"),
            edit = @Edit(
                    notNull = true,
                    search = @Search,
                    title = "产品模块选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态获取产品",
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name",
                            pid = "parent.id"))
    )
    private ProductModuleModel parent;

    @ManyToOne
    @JoinColumn(name = "root_product_id")
    @EruptField(
            views = @View(title = "所属产品",column = "details"),
            edit = @Edit(
                    notNull = true,
                    search = @Search,
                    title = "产品模块选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态获取产品",
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name",
                            pid = "parent.id"))
    )
    private ProductModuleModel product;

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
                    title = "优先级"
            ),
            edit = @Edit(
                    title = "优先级",
                    type = EditType.TAGS,
                    search = @Search,
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct key,detail from master_data where category_code = 'PRIORITY' order by 1 "
                    )
            )
    )
    private String priority = "P2";


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
                    title = "期望结果"
            ),
            edit = @Edit(
                    title = "期望结果",
                    type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "text")
            )
    )
    private String expectedResult;

    @EruptField(
            views = @View(
                    title = "用例ID"
            )
    )
    private String uuid;
    @EruptField(
            views = @View(
                    title = "用例前提条件"
            ),
            edit = @Edit(
                    title = "用例前提条件",
                    type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "text")
            )
    )
    private String precondition;

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPrecondition() {
        return precondition;
    }

    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }


    public ProductModuleModel getModule() {
        return module;
    }

    public void setModule(ProductModuleModel module) {
        this.module = module;
    }

    public ProductModuleModel getParent() {
        return parent;
    }

    public void setParent(ProductModuleModel parent) {
        this.parent = parent;
    }

    public ProductModuleModel getProduct() {
        return product;
    }

    public void setProduct(ProductModuleModel product) {
        this.product = product;
    }
}