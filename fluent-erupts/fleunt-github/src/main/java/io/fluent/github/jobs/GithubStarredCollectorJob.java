package io.fluent.github.jobs;

import cn.hutool.json.JSONUtil;
import io.fluent.builtin.StringUtils;
import io.fluent.github.service.GithubService;
import io.fluent.github.jobs.github.GithubJobFetchParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import xyz.erupt.core.annotation.EruptHandlerNaming;
import xyz.erupt.job.handler.EruptJobHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
@EruptHandlerNaming("Github Starred Repo Job")  // 如果不添加此配置，类名会作为前端展示依据
public class GithubStarredCollectorJob implements EruptJobHandler {
    @Resource
    private GithubService githubService;
    /**
     * @param code 任务编码
     * @param param 任务参数
     */

    @Override
    public String exec(String code, String param) {
        log.info("start job %s with parameter %s".formatted(code,param));
        GithubJobFetchParameters parameters  ;
        if(StringUtils.isAllEmpty(param)){
            parameters = new GithubJobFetchParameters();
        }else {
            parameters = JSONUtil.toBean(param, GithubJobFetchParameters.class);
        }
        saveGithubRepos(parameters);
        return "success";
    }

    private void saveGithubRepos(GithubJobFetchParameters parameters) {
        List<String> userNames=StringUtils.split(parameters.getUserNames(),",");
        for (String userName : userNames) {
            githubService.saveUserStarredRepo(userName, parameters.getFromPage());
        }
    }


    @Override
    public void success(String result, String param) {
        log.info(String.format("success result %s", result));
        EruptJobHandler.super.success(result, param);
    }

    @Override
    public void error(Throwable throwable, String param) {
        EruptJobHandler.super.error(throwable, param);
    }

}