package io.fluent.git.github;

import cn.hutool.json.JSONUtil;
import com.jcabi.github.Github;
import com.jcabi.github.RtGithub;
import com.jcabi.http.response.JsonResponse;
import io.fluent.git.github.enums.GithubDateRange;
import io.fluent.git.github.models.GithubRepoModel;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

/** 1. Get user starred number 2. Get Trending Information */
public class GithubUserServiceTest {
  Dotenv dotenv = Dotenv.load();
  String githubAccessToken = dotenv.get("GITHUB_ACCESS_TOKEN");

  Github github = new RtGithub(githubAccessToken);
  GithubUserService service = new GithubUserService();

  @Test
  public void createGithubClient() throws IOException {

    System.out.println(github.users());
    JsonResponse result =
        github
            .entry()
            .uri()
            .path("/users/qdriven/starred")
            .queryParam("per_page", "50")
            .queryParam("page", "0")
            .back()
            .fetch()
            .as(JsonResponse.class);
    List<GithubRepoModel> repos = JSONUtil.toList(result.body(), GithubRepoModel.class);
    System.out.println(repos);
  }

  @Test
  public void testUserStarred() throws IOException {
    var result =
        github.entry().uri().path("/users/qdriven/starred").back().fetch().as(JsonResponse.class);
    List<GithubRepoModel> repos = JSONUtil.toList(result.body(), GithubRepoModel.class);
    System.out.println(repos);
  }

  @Test
  public void testSaveGithubRepos() {
    GithubUserService service = new GithubUserService();
    service.saveUserStarredRepo("kennethreitz", 0);
  }

  @Test
  public void testGetGithubTrendingRepos()  {
    var result = service.getGithubTrendingRepos(GithubDateRange.Daily.toString());
    System.out.println(result);
  }
}
