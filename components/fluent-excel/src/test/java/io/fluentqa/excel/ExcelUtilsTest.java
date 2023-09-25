package io.fluentqa.excel;


import io.fluentqa.table.FluentExcelReader;
import io.fluentqa.table.FluentExcelWriter;
import io.fluentqa.table.base.TableType;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExcelUtilsTest {

    List<DemoExcelModel> data = Arrays.asList(new DemoExcelModel("k", 12),
            new DemoExcelModel("y", 10));

  @Test
  void testWriteToExcel() throws IOException {
    File demo= new File("demo.xlsx");
    FluentExcelWriter.create(TableType.XLSX).withRows(
      data
    ).to(demo);
  }
    @Test
    @Order(100)
    void testReadExcel() {
        List<DemoExcelModel> models =FluentExcelReader.create(DemoExcelModel.class,
                        new File("demo.xlsx"))
                .asList();
        System.out.println(models);

    }

  @AfterAll
  public  static void cleanUp() throws IOException {
    FileUtils.delete( new File("demo.xlsx"));
  }

}