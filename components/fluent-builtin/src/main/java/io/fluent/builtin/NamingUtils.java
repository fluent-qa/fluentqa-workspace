package io.fluent.builtin;

import cn.hutool.core.util.StrUtil;

public class NamingUtils {

    public static String underscoreToCamel(String value) {
        StringBuilder result = new StringBuilder();
        String[] arr = value.split(StringUtils.UNDERLINE);
        for (String s : arr) {
            result.append((String.valueOf(s.charAt(0))).toUpperCase()).append(s.substring(1));
        }
        return result.toString();
    }
    public static String camelToUnderscore(String value) {
        return StrUtil.toUnderlineCase(value);
    }
}
