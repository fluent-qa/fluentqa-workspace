package io.fluent.wrappers.feishu;

import com.lark.oapi.Client;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.ext.enums.FileTypeEnum;
import com.lark.oapi.service.ext.model.CreateFileReq;
import com.lark.oapi.service.ext.model.CreateFileReqBody;
import com.lark.oapi.service.ext.model.CreateFileResp;
import com.lark.oapi.service.im.v1.enums.MsgTypeEnum;
import com.lark.oapi.service.im.v1.model.ext.MessageText;

import java.util.HashMap;
import java.util.Map;

/**
 * 原生http 调用方式
 */
public class RawApiCall {

    public static void sendMsg() throws Exception {
        String appId = System.getenv().get("APP_ID");
        String appSecret = System.getenv().get("APP_SECRET");

        // 构建client
        Client client = Client.newBuilder(appId, appSecret)
                .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
                .logReqAtDebug(true)
                .build();

        // 构建http body
        Map<String, Object> body = new HashMap<>();
        body.put("receive_id", "ou_c245b0a7dff2725cfa2fb104f8b48b9d");
        body.put("content", MessageText.newBuilder()
                .atUser("ou_155184d1e73cbfb8973e5a9e698e74f2", "Tom")
                .text("test content")
                .build());
        body.put("msg_type", MsgTypeEnum.MSG_TYPE_TEXT);

        // 发起请求
        RawResponse resp = client.post(
                "https://open.feishu.cn/open-apis/im/v1/messages?receive_id_type=open_id"
                , body
                , AccessTokenType.Tenant);

        // 处理结果
        System.out.println(resp.getStatusCode());
        System.out.println(Jsons.DEFAULT.toJson(resp.getHeaders()));
        System.out.println(new String(resp.getBody()));
        System.out.println(resp.getRequestID());
    }


    public static void getTenantToken() throws Exception {
        String appId = System.getenv().get("APP_ID");
        String appSecret = System.getenv().get("APP_SECRET");

        // 构建client
        Client client = Client.newBuilder(appId, appSecret)
                .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
                .logReqAtDebug(true)
                .build();

        // 发起请求
        Map<String, Object> body = new HashMap<>();
        body.put("app_id", appId);
        body.put("app_secret", appSecret);
        RawResponse resp = client.post(
                "https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal"
                , body
                , AccessTokenType.None);

        // 处理结果
        System.out.println(resp.getStatusCode());
        System.out.println(Jsons.DEFAULT.toJson(resp.getHeaders()));
        System.out.println(new String(resp.getBody()));
        System.out.println(resp.getRequestID());
    }

    public static void createFile() throws Exception {
        String appId = System.getenv().get("APP_ID");
        String appSecret = System.getenv().get("APP_SECRET");

        // 构建client
        Client client = Client.newBuilder(appId, appSecret)
                .logReqAtDebug(true)
                .build();

        CreateFileResp resp = client.ext()
                .createFile(CreateFileReq.newBuilder()
                        .folderToken("fldcniHf40Vcv1DoEc8SXeuA0Zd")
                        .body(CreateFileReqBody.newBuilder()
                                .title("测试哎")
                                .type(FileTypeEnum.DOC)
                                .build())
                        .build(), RequestOptions.newBuilder()
                        .userAccessToken("u-3hVKsQTwR5H9j_tQbO2GoElg0Rggl543io00glM0277v")
                        .build());
        // 处理结果
        if (!resp.success()) {
            System.out.println(
                    String.format("%s,%s,%s", resp.getRequestId(), resp.getMsg(), resp.getCode()));
            return;
        }
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        System.out.println(resp.getRequestId());
    }

}