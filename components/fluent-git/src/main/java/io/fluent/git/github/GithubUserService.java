package io.fluent.git.github;

import cn.hutool.json.JSONUtil;
import com.jcabi.github.Github;
import com.jcabi.http.response.JsonResponse;
import io.fluent.git.github.models.GithubRepoModel;
import io.fluent.git.github.repo.GithubDao;

import java.io.IOException;
import java.util.List;

import static io.fluent.git.github.config.ConfigHolder.getGithubApiClient;

public class GithubUserService {

    private GithubDao githubDao = new GithubDao();
    private Github github = getGithubApiClient();

    public void saveUserStarredRepo(String userName) {
        int page = 0;
        int pageSize = 100;
        while (true) {
            JsonResponse result = null;
            try {
                result = github.entry().uri().path(String.format("/users/%s/starred", userName))
                        .queryParam("per_page", pageSize)
                        .queryParam("page", page)
                        .back().fetch().as(JsonResponse.class);
                List<GithubRepoModel> repos = JSONUtil.toList(result.body(), GithubRepoModel.class);
                githubDao.saveAll(repos);
                if (repos.size() < pageSize) break;
                page+=1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
