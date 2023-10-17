package io.fluent.git.github.entity;


import io.fluent.quickdao.annotations.QuickDaoColumn;
import lombok.Data;


@Data
public class GithubStarredRepo {
    private Long id;

    private String name;
    private String url;
    @QuickDaoColumn(name = "full_name")
    private String fullName;
    @QuickDaoColumn(name = "node_id")
    private String nodeId;
    private String description;
    @QuickDaoColumn(name = "forked_count")
    private int forkedCount;
    @QuickDaoColumn(name = "stargazers_count")
    private int stargazersCount;
    private String topics;
}
