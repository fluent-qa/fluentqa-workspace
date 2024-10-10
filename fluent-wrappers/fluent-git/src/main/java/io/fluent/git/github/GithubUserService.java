package io.fluent.git.github;

import static io.fluent.git.github.config.ConfigHolder.getGithubApiClient;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.jcabi.github.Github;
import com.jcabi.http.response.JsonResponse;
import io.fluent.git.github.entity.GithubTrendingRepo;
import io.fluent.git.github.enums.GithubDateRange;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

import io.fluent.git.github.models.GithubRepoModel;
import io.fluent.git.github.repo.GithubDao;
import java.io.IOException;
import java.util.List;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GithubUserService {
  int page = 1;
  int defaultPageSize = 50;
  private GithubDao githubDao = new GithubDao();
  private Github github = getGithubApiClient();

  @SneakyThrows
  // TODO: Add retry logic
  public void saveUserStarredRepo(String userName, int page) {
    while (true) {
      try {
        log.info("star to fetch page-{} data", page);
        int pageSize = saveIt(userName, page, defaultPageSize);
        if (pageSize < defaultPageSize) break;
        page += 1;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private int saveIt(String userName, int page, int pageSize)
      throws IOException, InterruptedException {
    log.info("start to fetch github repos");
    JsonResponse result =
        github
            .entry()
            .uri()
            .path(String.format("/users/%s/starred", userName))
            .queryParam("per_page", pageSize)
            .queryParam("page", page)
            .back()
            .fetch()
            .as(JsonResponse.class);

    List<GithubRepoModel> repos = JSONUtil.toList(result.body(), GithubRepoModel.class);
    githubDao.saveAll(repos);
    return repos.size();
  }

   public List<GithubTrendingRepo> getGithubTrendingRepos(String dateRange) {
    
        try {
            String url = String.format("https://github.com/trending?since=%s", dateRange);
            var client = new OkHttpClient();
            Request request = new Request.Builder()
                .url(url)
                .build();
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Document doc = Jsoup.parse(response.body().string());
                Elements repoElements = doc.select("article.Box-row");

                List<GithubTrendingRepo> trendingRepos = new ArrayList<>();
                for (Element repoElement : repoElements) {
                    String repoName = repoElement.selectXpath("h2").select("a").get(0).attr("href");
                    String description = repoElement.select("p.col-9").text();
                    String language = repoElement.select("span[itemprop=programmingLanguage]").text();
                    String stars = repoElement.select("a.Link--muted").first().text();
                    GithubTrendingRepo repo = new GithubTrendingRepo();
                    repo.setFullName(repoName);
                    repo.setUrl(StrUtil.join("","https://github.com",repoName));
                    repo.setDescription(description);
                    repo.setLanguages(language);
                    repo.setStargazersCount(Integer.parseInt(stars.replaceAll(",", "")));
                    trendingRepos.add(repo);
                }

                return trendingRepos;
            }
        } catch (IOException e) {
            log.error("Error fetching trending repositories", e);
            throw new RuntimeException("Failed to fetch trending repositories", e);
        }
    }

    public void saveGithubTrendingRepo(){
        for (GithubDateRange value : GithubDateRange.values()) {
            List<GithubTrendingRepo> models = getGithubTrendingRepos(value.toString());
            System.out.println(models);
        }
    }
}
