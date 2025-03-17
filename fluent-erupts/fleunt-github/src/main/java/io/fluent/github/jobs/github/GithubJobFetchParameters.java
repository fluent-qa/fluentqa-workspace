package io.fluent.github.jobs.github;

import lombok.Data;
//https://olakit.cn/box/quartz_cron_build_check
//0 0 23 ? * * *
@Data
public class GithubJobFetchParameters {
    private String userNames="qdriven";
    private int fromPage=0;
    private int pageSize=50;
}
