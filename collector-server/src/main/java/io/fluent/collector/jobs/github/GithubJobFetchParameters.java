package io.fluent.collector.jobs.github;

import lombok.Data;

@Data
public class GithubJobFetchParameters {
    private String userNames="qdriven";
    private int fromPage=0;
    private int pageSize=50;
}
