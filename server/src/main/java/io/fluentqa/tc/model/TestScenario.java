package io.fluentqa.tc.model;

import io.fluentqa.base.model.NamedModelVO;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;

import javax.persistence.*;
import java.util.Set;

/**
 * 1. 创建测试场景，关联测试用例
 */
@Entity
@Table(name = "test_scenarios")
@Erupt(name = "测试场景管理",
        power = @Power(importable = true, export = true)

)
//@PreDataProxy(value= TestScenarioCaseProxy.class)

public class TestScenario extends NamedModelVO {

    @JoinTable(name = "test_scenario_cases",
            joinColumns = @JoinColumn(name = "test_scenario_id", referencedColumnName = "id"),
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

    public Set<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(Set<TestCase> testCases) {
        this.testCases = testCases;
    }
}
