package io.fluentqa.builtin.config;

import cn.hutool.setting.dialect.PropsUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class PropUtils extends PropsUtil {

    public static Properties toProperties(String propString) {
        Properties p = new Properties();
        try {
            Objects.requireNonNull(propString, "should not be null");
            p.load(new ByteArrayInputStream(propString.getBytes()));
        } catch (IOException | NullPointerException e) {
            log.error("{} to properties failed,error ={}", propString, e.getStackTrace());
        }
        return p;
    }

}
