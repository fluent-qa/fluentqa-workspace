package io.fluent.builtin.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigExceptionTest {

    @Test
    public void testAppConfigException() {
        AppConfigException appConfigException = new AppConfigException(
                "this is appconfig exception"
        );
        assertEquals("this is appconfig exception", appConfigException.getMessage());
    }

}