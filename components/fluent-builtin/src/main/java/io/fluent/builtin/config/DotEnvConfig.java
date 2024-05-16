package io.fluent.builtin.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvConfig {

    static Dotenv dotenv = Dotenv.load();


    public static String getValue(String key) {
        return dotenv.get(key);
    }


}
