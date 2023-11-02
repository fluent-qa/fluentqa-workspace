package io.fluent.mocker.factory;


import io.fluent.mocker.mockbean.MockBean;
import io.fluent.mocker.mockbean.MockField;
import io.fluent.mocker.mockbean.MockMapBean;


public class MockBeanFactory {

    /**
     * 创建一个MockBean
     * @param objectClass
     * @param fields
     * @param <T>
     * @return
     */
    public static <T> MockBean<T> createMockBean(Class<T> objectClass, MockField[] fields){
        return new MockBean<>(objectClass, fields);
    }

    /**
     * 创建一个MockMapBean
     * @param fields
     * @return
     */
    public static MockMapBean createMockMapBean(MockField[] fields){
        return new MockMapBean(fields);
    }

}
