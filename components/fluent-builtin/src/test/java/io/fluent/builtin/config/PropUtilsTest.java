package io.fluent.builtin.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropUtilsTest {
    @Test
    public void testToProps(){
        var result = PropUtils.toProperties("test=key");
        assert result.get("test").equals("key");
    }
}