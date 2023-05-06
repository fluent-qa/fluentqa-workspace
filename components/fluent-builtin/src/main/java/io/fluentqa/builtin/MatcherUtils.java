package io.fluentqa.builtin;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtils {
    private static final Pattern CHINESE_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");

    public static boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean containChinese(String value) {
        if (StrUtil.isBlank(value)) {
            return false;
        }
        Matcher matcher = CHINESE_PATTERN.matcher(value);
        return matcher.find();
    }

}
