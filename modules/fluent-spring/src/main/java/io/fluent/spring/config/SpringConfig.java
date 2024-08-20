package io.fluent.spring.config;

import io.fluent.spring.util.SpringUtils;
import org.springframework.context.annotation.Bean;


public class SpringConfig {
    @Bean("springUtils")
    public SpringUtils springUtils() {
        return new SpringUtils();
    }
}
