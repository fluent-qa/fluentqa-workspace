package io.fluent.git.github.repo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.fluent.git.github.config.ConfigHolder;
import io.fluent.git.github.entity.GithubStarredRepo;
import io.fluent.git.github.models.GithubRepoModel;
import io.fluent.quickdao.QuickDao;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GithubDao {
    private QuickDao dao = ConfigHolder.getDao();


    public void save(GithubRepoModel model) {
        GithubStarredRepo entity = BeanUtil.copyProperties(model,
                GithubStarredRepo.class,"topics");

        entity.setTopics(StrUtil.join(",",model.getTopics()));
        dao.saveOrUpdate(entity,"github_starred_repo","node_id");
    }

    public void saveAll(List<GithubRepoModel> models){
        for (GithubRepoModel model : models) {
            log.info("start save model : {}", model.getFullName());
            save(model);
        }
    }

}
