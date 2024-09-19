package io.fluent.github.service;

import io.fluent.git.github.GithubUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GithubService {
    GithubUserService userService = new GithubUserService();

    public void saveUserStarredRepo(String userName,int page){
        log.info("start save all starred repos");
        userService.saveUserStarredRepo(userName,page);
        log.info("complete saved user starred repo");
    }
}
