package io.fluentqa.excel;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import java.io.IOException;
import java.util.List;

public class ExcelReadWriter {

  public <T> List<T> readExcel(String fileName, Class<T> clazz) {
    try {
      return ExcelUtils.getInstance().readExcel2Objects(fileName, clazz);
    } catch (Excel4JException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  public <T> void writeExcel(List<T> data, String fileName, Class<T> clazz) {
    try {
      ExcelUtils.getInstance().exportObjects2Excel(data, clazz, true, fileName);
    } catch (Excel4JException | IOException e) {
      throw new RuntimeException(e);
    }
  }
}
