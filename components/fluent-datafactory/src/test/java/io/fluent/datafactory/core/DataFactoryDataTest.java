package io.fluent.datafactory.core;

import io.fluent.datafactory.core.util.DataFactoryDataUtil;
import org.junit.jupiter.api.Test;

class DataFactoryDataTest {

    @Test
    public void testUserdata(){
        User user = DataFactoryDataUtil.build(User.class);
        System.out.println(user);
        UserAnnotationNumber userNumber = DataFactoryDataUtil.build(UserAnnotationNumber.class);
        System.out.println(userNumber);
    }

}