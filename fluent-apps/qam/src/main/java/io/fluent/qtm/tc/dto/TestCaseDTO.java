package io.fluent.qtm.tc.dto;

import com.github.crab2died.annotation.ExcelField;
import lombok.Data;

@Data
public class TestCaseDTO {
    @ExcelField(title = "产品名称")
    private String productName;
    @ExcelField(title = "模块名称")
    private String moduleName;
    @ExcelField(title = "功能点")
    private String feature;
    @ExcelField(title = "用例描述")
    private String summary;
    @ExcelField(title = "优先级")
    private String priority = "P2"; //check it
    @ExcelField(title = "用例前提条件")
    private String precondition;
    @ExcelField(title = "测试步骤")
    private String steps;
    @ExcelField(title = "期望结果")
    private String expectedResult;

    @ExcelField(title = "用例ID")
    private String uuid;

}
