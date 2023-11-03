package io.fluentqa.pm.requirement;


import io.fluentqa.base.handlers.SqlTagFetchHandler;
import io.fluentqa.base.model.ModelWithValidFlag;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.fun.ChoiceFetchHandler;
import xyz.erupt.annotation.fun.VLModel;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.TagsType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Erupt(name = "测试需求管理",
        power = @Power(export = true, importable = true),
        orderBy = "TestRequirement.updateTime desc",
        linkTree = @LinkTree(field = "module"))
@Table(name = "test_requirements")
public class TestRequirement extends ModelWithValidFlag implements ChoiceFetchHandler {

    @EruptField(
            views = @View(title = "需求概述"),
            edit = @Edit(title = "需求概述")
    )
    private String summary;

    @EruptField(
            views = @View(title = "需求类型"),
            edit = @Edit(title = "需求类型",
                    notNull = true, type = EditType.CHOICE,
                    choiceType = @ChoiceType(type = ChoiceType.Type.RADIO, fetchHandler = TestRequirement.class))
    )
    private String type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_req_id")
    @EruptField(
            edit = @Edit(title = "功能点", type = EditType.TAB_TABLE_ADD)
    )
    private Set<RequirementFeature> features;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_req_id")
    @OrderBy("sort")
    @EruptField(
            edit = @Edit(title = "字段管理", type = EditType.TAB_TABLE_ADD)
    )
    private Set<FieldOption> fieldOptions;

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
    private Product module;

    @EruptField(
            views = @View(
                    title = "提示词"
            ),
            edit = @Edit(
                    title = "提示词"
            )
    )
    private String prompts;

    @EruptField(
            views = @View(
                    title = "优先级"
            ),
            edit = @Edit(
                    search = @Search,
                    title = "优先级",
                    type = EditType.TAGS,
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct key,detail from master_data where category_code = 'PRIORITY' order by 1 "
                    )
            )
    )
    private String priority = "P2";

    @EruptField(
            views = @View(
                    title = "需求状态"
            ),
            edit = @Edit(
                    title = "需求状态"
            )
    )
    private String status;

    @Override
    public List<VLModel> fetch(String[] params) {
        List<VLModel> list = new ArrayList<>();
        for (RequirementType value : RequirementType.values()) {
            list.add(new VLModel(value.name(), value.getDesc()));
        }
        return list;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    public String getPrompts() {
        return prompts;
    }

    public void setPrompts(String prompts) {
        this.prompts = prompts;
    }


    public Set<FieldOption> getFieldOptions() {
        return fieldOptions;
    }

    public void setFieldOptions(Set<FieldOption> fieldOptions) {
        this.fieldOptions = fieldOptions;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<RequirementFeature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<RequirementFeature> features) {
        this.features = features;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getModule() {
        return module;
    }

    public void setModule(Product module) {
        this.module = module;
    }
}