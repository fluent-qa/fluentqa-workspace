package io.fluentqa.qtm.tc.model;


import io.fluentqa.base.model.ModelWithValidFlagVo;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "test_results")
@Entity
@Erupt(name = "测试执行结果",
        power = @Power(importable = true, export = true)
        , linkTree = @LinkTree(field = "testRun")
)
public class TestResult extends ModelWithValidFlagVo {
    @ManyToOne
    @EruptField(
            views = @View(title = "所属测试安排", column = "name"),
            edit = @Edit(title = "所属测试安排", type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id", expandLevel = 2))
    )
    private TestRun testRun;

    @EruptField(
            views = @View(
                    title = "测试场景"
            ),
            edit = @Edit(
                    title = "测试场景",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String testScenario;
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


    @EruptField(
            views = @View(
                    title = "测试测试结果"
            ),
            edit = @Edit(
                    title = "测试测试结果",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String qaTestResult;


    @EruptField(
            views = @View(
                    title = "测试负责人"
            ),
            edit = @Edit(
                    title = "测试负责人",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String qaOwner;

    private String testCaseUUID;


    public String getTestCaseUUID() {
        return testCaseUUID;
    }

    public void setTestCaseUUID(String testCaseUUID) {
        this.testCaseUUID = testCaseUUID;
    }

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


    public String getQaTestResult() {
        return qaTestResult;
    }

    public void setQaTestResult(String qaTestResult) {
        this.qaTestResult = qaTestResult;
    }

    public String getQaOwner() {
        return qaOwner;
    }

    public void setQaOwner(String qaOwner) {
        this.qaOwner = qaOwner;
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
    }

    public String getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(String testScenario) {
        this.testScenario = testScenario;
    }
}
