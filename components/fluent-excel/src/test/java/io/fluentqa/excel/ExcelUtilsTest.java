package io.fluentqa.excel;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ExcelUtilsTest {
  ExcelReadWriter readWriter = new ExcelReadWriter();
  List<DemoExcelModel> data =
      Arrays.asList(new DemoExcelModel("k", 12), new DemoExcelModel("y", 10));

  @Test
  void testWriteToExcel() throws IOException {
    readWriter.writeExcel(data, "demo.xlsx", DemoExcelModel.class);
  }

  @Test
  @Order(100)
  void testReadExcel() {
    List<DemoExcelModel> models = readWriter.readExcel("demo.xlsx", DemoExcelModel.class);
    System.out.println(models);
  }

  @AfterAll
  public static void cleanUp() throws IOException {
    FileUtils.delete(new File("demo.xlsx"));
  }
}
