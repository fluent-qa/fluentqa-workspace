package io.fluent.qtm.api.model;

import io.fluent.base.handlers.SqlTagFetchHandler;
import io.fluent.base.model.ModelWithValidFlag;
import io.fluent.base.product.model.ProductModuleModel;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.TagsType;

import javax.persistence.*;
import java.util.Set;

/**
 *
 */
@Entity
@Erupt(name = "接口测试用例",
        power = @Power(export = true),
        orderBy = "ApiTestScenario.updateTime desc",
        linkTree = @LinkTree(field = "module"),
        layout = @Layout(
        tableLeftFixed = 3,
        pageSize = 30))
@Table(name = "api_test_scenario")
public class ApiTestScenario extends ModelWithValidFlag {

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EruptField(
            views = @View(title = "所属模块", column = "details"),
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
                    title = "测试场景详细描述"
            ),
            edit = @Edit(
                    title = "测试场景详细描述",
                    type = EditType.TEXTAREA, search = @Search, notNull = true
            )
    )
    private String details;

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
            views = @View(title = "场景参数"),
            edit = @Edit(title = "场景参数",
                    type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "json"))
    )
    private String scenarioParameters;

    @JoinTable(name = "api_test_scenario_steps",
            joinColumns = @JoinColumn(name = "api_test_scenario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "api_test_step_id", referencedColumnName = "id"))
    @ManyToMany(fetch = FetchType.EAGER)
    @EruptField(
            views = @View(title = "包含用例"),
            edit = @Edit(
                    title = "包含用例",
                    type = EditType.TAB_TABLE_REFER
            )
    )
    private Set<ApiStep> testSteps;
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    public ProductModuleModel getModule() {
        return module;
    }

    public void setModule(ProductModuleModel module) {
        this.module = module;
    }

    public String getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(String testScenario) {
        this.testScenario = testScenario;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getScenarioParameters() {
        return scenarioParameters;
    }

    public void setScenarioParameters(String scenarioParameters) {
        this.scenarioParameters = scenarioParameters;
    }

    public Set<ApiStep> getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(Set<ApiStep> testSteps) {
        this.testSteps = testSteps;
    }
}