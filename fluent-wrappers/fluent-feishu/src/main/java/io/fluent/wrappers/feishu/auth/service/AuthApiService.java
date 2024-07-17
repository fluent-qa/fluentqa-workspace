// package io.fluent.wrappers.feishu.auth.service;
//
// import cn.hutool.core.util.StrUtil;
// import cn.hutool.http.HttpUtil;
// import io.fluent.wrappers.feishu.auth.dto.req.TenantAccessTokenGetReqDTO;
// import io.fluent.wrappers.feishu.auth.dto.resp.TenantAccessTokenGetRespDTO;
// import lombok.Data;
//
// import java.util.concurrent.TimeUnit;
// import java.util.concurrent.atomic.AtomicLong;
//
/// **
// * 飞书认证api接口
// *
// * @author Tao.Liu
// * @date 2022/6/29 13:55
// */
// @Data
// public class AuthApiService {
//
//    public final static String BASE_URL = "https://open.feishu.cn/open-apis/auth";
//
//
//
//
//    /**
//     * 过期时间
//     */
//    private AtomicLong EXPIRE_TIMES = new AtomicLong();
//
//    /**
//     * 企业自建应用token
//     */
//    private String tenantAccessToken = "";
//
//    /**
//     * 应用ID
//     */
//    private String appId;
//
//    /**
//     * 应用名称
//     */
//    private String appSecret;
//
//
//    public AuthApiService(final String appId, final String appSecret) {
//        this.appId = appId;
//        this.appSecret = appSecret;
//    }
//
//    /**
//     * 企业自建应用token
//     *
//     * @return
//     */
//    public String getTenantAccessToken() {
//        if (StrUtil.isNotBlank(tenantAccessToken) && System.currentTimeMillis() <
// EXPIRE_TIMES.get()) {
//            return this.tenantAccessToken;
//        }
//
//        synchronized (this) {
//            final TenantAccessTokenGetReqDTO tokenGetReqDTO = new
// TenantAccessTokenGetReqDTO(appId, appSecret);
//            final TenantAccessTokenGetRespDTO tokenRespDTO = HttpUtil.post(BASE_URL +
// "/v3/tenant_access_token/internal",
//                    tokenGetReqDTO, TenantAccessTokenGetRespDTO.class);
//            if (tokenGetReqDTO == null && Strings.isBlank(tokenRespDTO.getTenantAccessToken())) {
//                throw new FeishuException(FeishuErrorCodeEnum.TABLE_ERROR, "获取飞书token出错");
//            }
//
//            // 设置过期时间，提前半小时失效
//            final long expireMills = TimeUnit.SECONDS.toMillis(tokenRespDTO.getExpire() - 1800);
//            EXPIRE_TIMES.set(System.currentTimeMillis() + expireMills);
//            this.tenantAccessToken = tokenRespDTO.getTenantAccessToken();
//            return this.tenantAccessToken;
//        }
//    }
//
// }
