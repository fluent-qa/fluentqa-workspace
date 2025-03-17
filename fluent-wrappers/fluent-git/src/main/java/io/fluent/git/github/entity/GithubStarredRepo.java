package io.fluent.git.github.entity;

import io.fluent.quickdao.annotations.QuickDaoColumn;
import lombok.Data;

@Data
public class GithubStarredRepo {
  private Long id;
  private String name;
  private String url;
  @QuickDaoColumn(name = "html_url")
  private String htmlUrl;

  @QuickDaoColumn(name = "full_name")
  private String fullName;

  @QuickDaoColumn(name = "node_id")
  private String nodeId;

  private String description;

  @QuickDaoColumn(name = "forks_count")
  private int forksCount;

  @QuickDaoColumn(name = "stargazers_count")
  private int stargazersCount;

  private String topics;
}
