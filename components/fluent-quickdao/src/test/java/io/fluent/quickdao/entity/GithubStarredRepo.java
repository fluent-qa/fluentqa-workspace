package io.fluent.quickdao.entity;


import lombok.Data;


@Data
public class GithubStarredRepo {
    private Long id;

    private String name;
    private String url;
    private String fullName;

    private String nodeId;
    private String description;
    private int forkedCount;
    private int stargazersCount;

    private String topics ;
}
