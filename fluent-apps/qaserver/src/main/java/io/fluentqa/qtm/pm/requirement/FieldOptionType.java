package io.fluentqa.qtm.pm.requirement;

import lombok.Getter;

@Getter
public enum FieldOptionType {
    NUMBER("数值"),STRING("字符串"),RELATION("关联"),DATE("日期"),ENUM("枚举"),BOOLEAN("布尔");

    private String desc;
    FieldOptionType(String desc) {
        this.desc = desc;
    }
}
