
```
- 导出
    1.正规excel导出 (格式简单,数据量可以,5W以内吧)
        注解方式:  ExcelExportUtil.exportExcel(ExportParams entity, Class<?> pojoClass,Collection<?> dataSet) 
    2.不定多少列,但是格式依然简单数据库不大
        自定义方式: ExcelExportUtil.exportExcel(ExportParams entity, List<ExcelExportEntity> entityList,Collection<?> dataSet)
    3.数据量大超过5W,还在100W以内
        注解方式 ExcelExportUtil.exportBigExcel(ExportParams entity, Class<?> pojoClass,IExcelExportServer server, Object queryParams)
        自定义方式: ExcelExportUtil.exportBigExcel(ExportParams entity, List<ExcelExportEntity> excelParams,IExcelExportServer server, Object queryParams)
    4.样式复杂,数据量尽量别大
        模板导出 ExcelExportUtil.exportExcel(TemplateExportParams params, Map<String, Object> map)
    5.一次导出多个风格不一致的sheet
        模板导出 ExcelExportUtil.exportExcel(Map<Integer, Map<String, Object>> map,TemplateExportParams params) 
    6.一个模板但是要导出非常多份
        模板导出 ExcelExportUtil.exportExcelClone(Map<Integer, List<Map<String, Object>>> map,TemplateExportParams params)
    7.模板无法满足你的自定义,试试html
        自己构造html,然后我给你转成excel  ExcelXorHtmlUtil.htmlToExcel(String html, ExcelType type)
    8.数据量过百万级了.放弃excel吧,csv导出
        注解方式: CsvExportUtil.exportCsv(CsvExportParams params, Class<?> pojoClass, OutputStream outputStream)
        自定义方式: CsvExportUtil.exportCsv(CsvExportParams params, List<ExcelExportEntity> entityList, OutputStream outputStream)
    9.word导出
        模板导出: WordExportUtil.exportWord07(String url, Map<String, Object> map)
    10.PDF导出
        模板导出: TODO 
- 导入 
    如果想提高性能 ImportParams 的concurrentTask 可以帮助并发导入,仅单行,最小1000
    excel有单个的那种特殊读取,readSingleCell 参数可以支持
    1. 不需要检验,数据量不大(5W以内)
        注解或者MAP: ExcelImportUtil.importExcel(File file, Class<?> pojoClass, ImportParams params)
    2. 需要导入,数据量不大
        注解或者MAP: ExcelImportUtil.importExcelMore(InputStream inputstream, Class<?> pojoClass, ImportParams params)
    3. 数据量大了,或者你有特别多的导入操作,内存比较少,仅支持单行
       SAX方式  ExcelImportUtil.importExcelBySax(InputStream inputstream, Class<?> pojoClass, ImportParams params, IReadHandler handler)
    4. 数据量超过EXCEL限制,CSV读取
        小数据量: CsvImportUtil.importCsv(InputStream inputstream, Class<?> pojoClass,CsvImportParams params)
        大数据量: CsvImportUtil.importCsv(InputStream inputstream, Class<?> pojoClass,CsvImportParams params, IReadHandler readHandler)
```