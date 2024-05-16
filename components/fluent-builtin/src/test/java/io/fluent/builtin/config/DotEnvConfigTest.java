package io.fluent.builtin.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DotEnvConfigTest {

    @Test
    public void testGetValue(){
        var result = DotEnvConfig.getValue("TW_BEAR_TOKEN");
        System.out.println(result);
    }
}