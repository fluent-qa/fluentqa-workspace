package io.fluentqa.builtin.constant.enums;

/**
 * <p> 代理类型枚举 </p>
 */
public enum ProxyTypeEnum {

    /**
     * 不执行任何代理
     */
    NONE,

    /**
     * jdk 动态代理
     */
    DYNAMIC,

    /**
     * cglib 动态代理
     */
    CGLIB;

}
