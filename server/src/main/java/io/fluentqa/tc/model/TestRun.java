package io.fluentqa.tc.model;


import io.fluentqa.pm.product.model.ProductModuleModel;
//import io.fluentqa.tc.handlers.GenerateTestRecordHandler;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.MetaModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//TODO: Filter By Status
//TODO: input by Uploaded File or File Sync
@Entity
@Table(name = "test_runs")
@Erupt(name = "测试执行计划",
        power = @Power(importable = true, export = true),
        tree = @Tree(id = "id", label = "name", pid = "parent.id")
//        ,rowOperation = {@RowOperation(
//                title = "生成执行测试用例",
//                operationHandler = GenerateTestRecordHandler.class)}
)

public class TestRun extends MetaModel {

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EruptField(
            views = @View(title = "产品名称", column = "name"),
            edit = @Edit(
                    search = @Search,
                    title = "产品选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态获取产品",
                    referenceTreeType = @ReferenceTreeType(
                            pid = "parent.id"))
    )
    private ProductModuleModel product;

    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "父级测试安排",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private TestRun parent;


    @EruptField(
            views = @View(
                    title = "测试负责人"
            ),
            edit = @Edit(
                    title = "测试负责人",
                    type = EditType.INPUT, search = @Search
            )
    )
    private String testOwner;

    @JoinTable(name = "test_run_cases",
            joinColumns = @JoinColumn(name = "test_run_id", referencedColumnName = "id"),
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

    @JoinTable(name = "test_run_scenario",
            joinColumns = @JoinColumn(name = "test_run_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "test_scenario_id", referencedColumnName = "id"))
    @ManyToMany(fetch = FetchType.EAGER)
    @EruptField(
            views = @View(title = "包含测试场景"),
            edit = @Edit(
                    title = "包含测试场景",
                    type = EditType.TAB_TABLE_REFER
            )
    )
    private Set<TestScenario> testScenarios;

    public ProductModuleModel getProduct() {
        return product;
    }

    public void setProduct(ProductModuleModel product) {
        this.product = product;
    }

    public String getTestOwner() {
        return testOwner;
    }

    public void setTestOwner(String testOwner) {
        this.testOwner = testOwner;
    }

    public Set<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(Set<TestCase> testCases) {
        this.testCases = testCases;
    }

    public Set<TestScenario> getTestScenarios() {
        return testScenarios;
    }

    public void setTestScenarios(Set<TestScenario> testScenarios) {
        this.testScenarios = testScenarios;
    }

    public TestRun getParent() {
        return parent;
    }

    public void setParent(TestRun parent) {
        this.parent = parent;
    }

    @EruptField(
            views = @View(
                    title = "名称"
            ),
            edit = @Edit(
                    title = "名称",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String name;
    @EruptField(
            views = @View(
                    title = "详细"
            ),
            edit = @Edit(
                    title = "详细",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String detail;
    @EruptField(
            views = @View(
                    title = "开始时间"
            ),
            edit = @Edit(
                    title = "开始时间",
                    type = EditType.DATE, search = @Search,
                    boolType = @BoolType
            )
    )
    private LocalDate startDate;
    @EruptField(
            views = @View(
                    title = "预计完成时间"
            ),
            edit = @Edit(
                    title = "预计完成时间",
                    type = EditType.DATE, search = @Search,
                    boolType = @BoolType
            )
    )
    private LocalDate estimatedCompletedDate;
    @EruptField(
            views = @View(
                    title = "完成时间"
            ),
            edit = @Edit(
                    title = "完成时间",
                    type = EditType.DATE, search = @Search,
                    boolType = @BoolType
            )
    )
    private LocalDate completedDate;
    @EruptField(
            views = @View(
                    title = "当前状态"
            ),
            edit = @Edit(
                    title = "当前状态",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    boolType = @BoolType
            )
    )
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEstimatedCompletedDate() {
        return estimatedCompletedDate;
    }

    public void setEstimatedCompletedDate(LocalDate estimatedCompletedDate) {
        this.estimatedCompletedDate = estimatedCompletedDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
