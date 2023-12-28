package io.fluent.git.github;

import cn.hutool.json.JSONUtil;
import com.jcabi.github.Github;
import com.jcabi.http.request.DefaultResponse;
import com.jcabi.http.response.JsonResponse;
import io.fluent.git.github.models.GithubRepoModel;
import io.fluent.git.github.repo.GithubDao;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

import static io.fluent.git.github.config.ConfigHolder.getGithubApiClient;

@Slf4j
public class GithubUserService {
    int page = 1;
    int defaultPageSize = 50;
    private GithubDao githubDao = new GithubDao();
    private Github github = getGithubApiClient();

    @SneakyThrows
    //TODO: Add retry logic
    public void saveUserStarredRepo(String userName,int page) {
        while (true) {
            try {
                log.info("star to fetch page-{} data",page);
                int pageSize = saveIt(userName, page, defaultPageSize);
                if (pageSize<defaultPageSize) break;
                page+=1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private int saveIt(String userName, int page, int pageSize) throws IOException, InterruptedException {
        log.info("start to fetch github repos");
        JsonResponse result = github.entry().uri().path(String.format("/users/%s/starred", userName))
                .queryParam("per_page", pageSize)
                .queryParam("page", page)
                .back().fetch().as(JsonResponse.class);

        List<GithubRepoModel> repos = JSONUtil.toList(result.body(), GithubRepoModel.class);
        githubDao.saveAll(repos);
        return repos.size();
    }
}
