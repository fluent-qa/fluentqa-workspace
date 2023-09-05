package io.fluentqa.tc.model;


import io.fluentqa.erupts.base.model.ModelWithValidFlagVo;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTableType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.*;
import java.util.Set;

/**
 * Test Record Entity: 主要操作对象
 *  * Test Case Entity
 *  * upload to test case table from mindmap or xmind
 *  * in a given format
 *  *
 *  * 1. 编写测试用例
 *  * 2. 编写测试计划，并上传测试用例
 *  * 3. 设置测试需要负责开发
 *  * 4. 测试用例修改
 *  * 5. 测试用例添加
 *  * 6. 脑图插件
 */
@Data
@Table(name = "test_records")
@Entity
@Erupt(name="测试执行",linkTree = @LinkTree(field = "testRequirement")
)
public class TestRecord extends ModelWithValidFlagVo {
    @ManyToOne
    @JoinColumn(name = "tr_id")
    @EruptField(
            views = @View(title = "需求名称", column = "name"),
            edit = @Edit(
                    search = @Search,
                    title = "需求选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "需求选择",
                    referenceTreeType = @ReferenceTreeType(
                            pid = "parent.id"))
    )
    private TestRequirement testRequirement;

    @ManyToOne
    @JoinColumn(name = "test_plan_id")
    @EruptField(
            views = @View(title = "测试计划", column = "name"),
            edit = @Edit(
                    search = @Search,
                    title = "测试计划选择",
                    type = EditType.REFERENCE_TABLE,
                    desc = "测试计划选择",
                    referenceTableType = @ReferenceTableType(id = "id", label = "name"))
    )
    private TestPlan testPlan;
//


    @JoinTable(name = "test_record_cases",
            joinColumns = @JoinColumn(name = "test_record_id", referencedColumnName = "id"),
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

//    @EruptField(
//            views = @View(
//                    title = "功能点"
//            ),
//            edit = @Edit(
//                    title = "功能点",
//                    type = EditType.INPUT, search = @Search, notNull = true
//            )
//    )
//    private String feature;
//    @EruptField(
//            views = @View(
//                    title = "用例描述"
//            ),
//            edit = @Edit(
//                    title = "用例描述",
//                    type = EditType.INPUT, notNull = true
//            )
//    )
//    private String summary;
//    @EruptField(
//            views = @View(
//                    title = "用例优先级"
//            ),
//            edit = @Edit(
//                    title = "用例优先级",
//                    type = EditType.INPUT, search = @Search, notNull = true
//            )
//    )
//    private String priority = "P2"; //check it
//    @EruptField(
//            views = @View(
//                    title = "测试步骤"
//            ),
//            edit = @Edit(
//                    title = "测试步骤",
//                    type = EditType.CODE_EDITOR, notNull = true,
//                    codeEditType = @CodeEditorType(language = "text")
//            )
//    )
//    private String steps;
//    @EruptField(
//            views = @View(
//                    title = "用例期望结果"
//            ),
//            edit = @Edit(
//                    title = "用例期望结果",
//                    type = EditType.CODE_EDITOR, notNull = true,
//                    codeEditType = @CodeEditorType(language = "text")
//            )
//    )
//    private String expectedResult;

    @EruptField(
            views = @View(
                    title = "开发自测结果"
            ),
            edit = @Edit(
                    title = "开发自测结果",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String devTestResult;
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
                    title = "回归测试结果"
            ),
            edit = @Edit(
                    title = "回归测试结果",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String releaseTestResult;
    @EruptField(
            views = @View(
                    title = "开发负责人"
            ),
            edit = @Edit(
                    title = "开发负责人",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String devOwner;
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


}
