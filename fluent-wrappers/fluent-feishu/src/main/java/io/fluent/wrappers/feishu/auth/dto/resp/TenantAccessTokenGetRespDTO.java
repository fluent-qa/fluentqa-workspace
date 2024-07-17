package io.fluent.wrappers.feishu.auth.dto.resp;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/** 企业自建应用token获取请求参数 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TenantAccessTokenGetRespDTO {

  /** 响应码 */
  private Integer code;

  /** 消息 */
  private String msg;

  /** token */
  private String tenantAccessToken;

  /** 过期时间 */
  private Integer expire;
}
