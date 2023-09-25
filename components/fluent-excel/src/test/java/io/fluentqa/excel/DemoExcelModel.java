package io.fluentqa.excel;


import com.github.crab2died.annotation.ExcelField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoExcelModel {
    @ExcelField(title = "名称")
    private String name;
    @ExcelField(title = "年纪")
    private Integer age;
}
