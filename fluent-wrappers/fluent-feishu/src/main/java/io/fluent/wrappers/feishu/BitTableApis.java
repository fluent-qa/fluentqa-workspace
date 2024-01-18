package io.fluent.wrappers.feishu;

import com.lark.oapi.Client;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.enums.BatchCreateAppTableRecordUserIdTypeEnum;
import com.lark.oapi.service.bitable.v1.enums.CreateAppTableRecordUserIdTypeEnum;
import com.lark.oapi.service.bitable.v1.model.*;

import java.util.HashMap;
import java.util.Map;

public class BitTableApis {


    public static void createTableRecord(Client client) throws Exception {

        Map<String, Object> fields = new HashMap<>();
        fields.put("name", "zlx");
        fields.put("sex", "male");
        fields.put("Date", 1612108800000L);
        fields.put("number", 1234L);
        fields.put("url", Url.newBuilder()
                .link("https://bytedance.feishu.cn/drive/home/")
                .text("我是加多")
                .build());
//    fields.put("Attachment",
//        new Attachment[]{Attachment.newBuilder().fileToken("boxcnnIpo5luPZtLWjuyJpuo9yf").build()});

        CreateAppTableRecordReq req = CreateAppTableRecordReq.newBuilder()
                .userIdType(CreateAppTableRecordUserIdTypeEnum.USER_ID)
                .tableId("tbl9a6pWtNVFsSrQ")
                .appToken("bascnpApISZqKuO0uEbcOzGcH6b")
                .appTableRecord(AppTableRecord.newBuilder()
                        .fields(fields)
                        .build())
                .build();

        // 发起请求
        CreateAppTableRecordResp resp = client.bitable().appTableRecord()
                .create(req, RequestOptions.newBuilder()
                        .userAccessToken("u-2Q0ERNI7F6FaiEU3HzuqR90glhox4leHPi005gO025Qz")
                        .build());

        // 处理服务端错误
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp));
    }


    public static void batchCreateTableRecord(Client client) throws Exception {
        Map<String, Object> fields = new HashMap<>();
//    fields.put("name", "zlx");
//    fields.put("sex", "male");
//    fields.put("Date", 1612108800000L);
        fields.put("aid", 121212);
        fields.put("tag", Url.newBuilder()
                .link("https://bytedance.feishu.cn/drive/home/")
                .text("我是加多")
                .build());
        AppTableRecord record = AppTableRecord.newBuilder()
                .fields(fields)
                .build();

        BatchCreateAppTableRecordReq req = BatchCreateAppTableRecordReq.newBuilder()
                .userIdType(BatchCreateAppTableRecordUserIdTypeEnum.USER_ID)
                .tableId("tbl2CfTdOZ2cuTMD")
                .appToken("bascnXiAbRDW2azUWZECiBc2Hrd")
                .batchCreateAppTableRecordReqBody(BatchCreateAppTableRecordReqBody.newBuilder()
                        .records(new AppTableRecord[]{record, record})
                        .build())
                .build();

        // 发起请求
        BatchCreateAppTableRecordResp resp = client.bitable().appTableRecord()
                .batchCreate(req, RequestOptions.newBuilder()
                        .userAccessToken("u-2Q0ERNI7F6FaiEU3HzuqR90glhox4leHPi005gO025Qz")
                        .build());

        // 处理服务端错误
        if (resp.getCode() != 0) {
            System.out.println(String.format("code:%d,msg:%s,err:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp));
    }

//    public static void main(String arg[]) throws Exception {
//        // 构建client
//        String appId = System.getenv().get("APP_ID");
//        String appSecret = System.getenv().get("APP_SECRET");
//
//        Client client = Client.newBuilder(appId, appSecret).build();
//        createTableRecord(client);
//    }


}