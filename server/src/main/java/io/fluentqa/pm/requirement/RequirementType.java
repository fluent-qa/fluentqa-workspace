package io.fluentqa.pm.requirement;

import lombok.Getter;

@Getter
public enum RequirementType {
    CREATE("创建"),UPDATE("更新"),DELETE("删除/归档"),SEARCH("查询"), COMPLEX("复杂业务"),
    WORKFLOW("工作流"),
    REPORT("报表"),OTHER("其他");

    private String desc;
    RequirementType(String desc) {
        this.desc = desc;
    }
}
