package io.fluentqa.tc.model;


import io.fluentqa.erupts.base.model.NamedTimeStatusModel;
import io.fluentqa.pm.product.model.Product;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.*;
import java.util.Set;

/**
 * 1. 创建测试计划
 * 2. 上传test case 文件，或者指定文件地址
 * 3. 生成测试用例-后台异步执行
 * 4.
 * 2.
 */
@Entity
@Table(name = "test_plans")
@Erupt(name = "测试计划管理",
        power = @Power(importable = true, export = true)
        ,linkTree = @LinkTree(field = "testRequirement")
)
public class TestPlan extends NamedTimeStatusModel {

    @EruptField(
            views = @View(
                    title = "负责人"
            ),
            edit = @Edit(
                    title = "负责人",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String owner;

    @ManyToOne
    @JoinColumn(name = "tr_id")
    @EruptField(
            views = @View(title = "需求名称", column = "name"),
            edit = @Edit(
                    search = @Search,
                    title = "需求选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态需求",
                    referenceTreeType = @ReferenceTreeType(
                            pid = "parent.id"))
    )
    private TestRequirement testRequirement;

    @JoinTable(name = "test_plan_cases",
            joinColumns = @JoinColumn(name = "test_plan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "test_case_id", referencedColumnName = "id"))
    @ManyToMany(fetch = FetchType.EAGER)
    @EruptField(
            views = @View(title = "包含用例"),
            edit = @Edit(
                    title = "包含用例",
                    type = EditType.TAB_TABLE_REFER
            )
    )
    private Set<TestCase> testCases;
}
