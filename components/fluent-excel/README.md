# Excel Utility README

Excel Utilities

## 1. Usage

```java
public class ExcelUtilsTest {
  ExcelReadWriter readWriter = new ExcelReadWriter();
    List<DemoExcelModel> data = Arrays.asList(new DemoExcelModel("k", 12),
            new DemoExcelModel("y", 10));

  @Test
  void testWriteToExcel() throws IOException {
    readWriter.writeExcel(data,"demo.xlsx",DemoExcelModel.class);
  }
    @Test
    @Order(100)
    void testReadExcel() {
        List<DemoExcelModel> models =readWriter.readExcel("demo.xlsx",
                        DemoExcelModel.class);
        System.out.println(models);

    }

  @AfterAll
  public  static void cleanUp() throws IOException {
    FileUtils.delete( new File("demo.xlsx"));
  }

}
```

- writeExcel
- readExcel 
