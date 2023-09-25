//package io.fluentqa.proxy;
//
//
//import cewqa.excel.ExcelReadWriter;
//import cewqa.ws.agile.testmgt.dto.TestCaseDTO;
//import cewqa.ws.agile.testmgt.service.TestCaseService;
//import cewqa.ws.product.model.ProductMeta;
//import cewqa.ws.sync.service.MindMappingService;
//import cn.hutool.core.bean.BeanUtil;
//import lombok.extern.slf4j.Slf4j;
//import xyz.erupt.core.prop.EruptProp;
//import xyz.erupt.core.util.EruptSpringUtil;
//import xyz.erupt.jpa.model.MetaDataProxy;
//import xyz.erupt.jpa.model.MetaModel;
//
//import java.util.List;
//
//@Slf4j
//public class SyncFileDataProxy extends MetaDataProxy {
//    private final MindMappingService mindMappingService;
//    private final TestCaseService testCaseService;
//    private final EruptProp eruptProp;
//    private final ExcelReadWriter excelReadWriter;
//
//    public SyncFileDataProxy() {
//        mindMappingService = EruptSpringUtil.getBean(MindMappingService.class);
//        testCaseService = EruptSpringUtil.getBean(TestCaseService.class);
//        eruptProp = EruptSpringUtil.getBean(EruptProp.class);
//        excelReadWriter = new ExcelReadWriter();
//    }
//
//    @Override
//    public void beforeAdd(MetaModel metaModel) {
//        //before add, add some check here
//        super.beforeAdd(metaModel);
//    }
//
//    @Override
//    public void afterAdd(MetaModel metaModel) {
//        //after add, then doing business process
//        log.info("start handler uploaded file");
//        String filePath = getUploaderFilePath(metaModel);
//        String uploadType = BeanUtil.getProperty(metaModel, "usage");
//
//        if(UploadFileTypeEnum.parseType(uploadType).equals(UploadFileTypeEnum.EXCEL_TC)){
//            ProductMeta product = BeanUtil.getProperty(metaModel, "product");
//            ProductMeta module = BeanUtil.getProperty(metaModel, "module");
//            testCaseService.saveProductCases(getExcelTestCases(filePath),product,module);
//        }
//        if(UploadFileTypeEnum.parseType(uploadType).equals(UploadFileTypeEnum.FREEMIND)){
//            mindMappingService.saveTestCases(filePath,metaModel);
//        }
//    }
//
//    private List<TestCaseDTO> getExcelTestCases(String filePath){
//       return excelReadWriter.readExcel(filePath, TestCaseDTO.class);
//    }
//
//    private String getUploaderFilePath(MetaModel metaModel) {
//        return eruptProp.getUploadPath() + BeanUtil.getProperty(metaModel, "attachment");
//    }
//
//}
