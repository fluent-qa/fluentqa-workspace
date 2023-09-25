package io.fluentqa.proxy;

public enum UploadFileTypeEnum {
    EXCEL_TC,FREEMIND,PM;

    public static UploadFileTypeEnum parseType(String uploadFileType) {
        for (UploadFileTypeEnum uploadFileTypeEnum : UploadFileTypeEnum.values()) {
            if (uploadFileTypeEnum.name().equals(uploadFileType)) {
                return uploadFileTypeEnum;
            }
        }
       throw  new RuntimeException("UploadFileTypeEnum is not found for " + uploadFileType);
    }
}
