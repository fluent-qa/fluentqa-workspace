package io.fluentqa.table.excel;


import io.fluentqa.table.excel.annotation.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoExcelModel {
    @ExcelColumn(index = 0,title = "名称")
    private String name;
    @ExcelColumn(index = 1,title = "年纪")
    private Integer age;
}
