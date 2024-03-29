package io.fluent.mocker.invoker;

/**
 * 执行者接口，定义了一个执行者的函数，执行者会通过invoke()方法获得结果
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 */
@FunctionalInterface
public interface Invoker {

    /**
     * 返回方法执行的结果
     * @return 获取执行结果
     * @throws Exception 可能会存在异常
     */
    Object invoke() throws Exception;
}

