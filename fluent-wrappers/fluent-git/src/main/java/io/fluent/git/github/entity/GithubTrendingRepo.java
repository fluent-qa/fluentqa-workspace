package io.fluent.git.github.entity;

import io.fluent.git.github.models.GithubRepoModel;
import io.fluent.quickdao.annotations.QuickDaoColumn;
import lombok.Data;

import java.util.Date;

@Data
public class GithubTrendingRepo  {
    private Long id;
    @QuickDaoColumn(name = "name")
    private String name;
    @QuickDaoColumn(name = "trending_date")
    private String url;
    @QuickDaoColumn(name = "full_name")
    private String fullName;

    @QuickDaoColumn(name = "node_id")
    private String nodeId;
    @QuickDaoColumn(name = "description")
    private String description;

    @QuickDaoColumn(name = "forks_count")
    private int forksCount;

    @QuickDaoColumn(name = "stargazers_count")
    private int stargazersCount;

    @QuickDaoColumn(name = "topics")
    private String topics;

  @QuickDaoColumn(name = "languages")
  private String languages;

    @QuickDaoColumn(name = "date_range")
    private String dateRange;

    @QuickDaoColumn(name = "trending_date")
    private Date trendingDate;


}
