package io.fluent.builtin;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PingYinUtils {

    public static String convertToPinyinAbbreviation(String chineseName) {
        StringBuilder abbreviation = new StringBuilder();

        // 将中文名转换为拼音数组
        char[] chineseNameArray = chineseName.toCharArray();
        for (char c : chineseNameArray) {
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
            for (String pinyin : pinyinArray) {
                // 提取每个拼音的首字母
                abbreviation.append(pinyin.charAt(0));
            }

        }
        return abbreviation.toString().toUpperCase();
    }
}
