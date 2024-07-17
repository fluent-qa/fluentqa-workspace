package io.fluent.wrappers.feishu.common.constant;

/**
 * 飞书错误码
 *
 * @author Tao.Liu
 * @date 2021/12/9 14:50
 */
public enum FeishuErrorCodeEnum {
  TABLE_ERROR("smith.feishu_table_error", "飞书接口响应异常"),
  TRY_AGAIN_LATER("cade.feishu_try_again_later", "请求超时，请稍后重试"),
  ;
  /** 错误码 */
  private final String code;

  /** 消息 */
  private final String message;

  FeishuErrorCodeEnum(final String code, final String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
