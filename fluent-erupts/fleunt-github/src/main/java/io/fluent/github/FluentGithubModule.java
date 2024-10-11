package io.fluent.github;

import io.fluent.github.model.AwesomeResource;
import io.fluent.github.model.GithubStarredRepo;
import io.fluent.github.model.GithubTrendingRepo;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import xyz.erupt.core.annotation.EruptScan;
import xyz.erupt.core.constant.MenuTypeEnum;
import xyz.erupt.core.module.EruptModule;
import xyz.erupt.core.module.EruptModuleInvoke;
import xyz.erupt.core.module.MetaMenu;
import xyz.erupt.core.module.ModuleInfo;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@EntityScan
@EruptScan
@EnableConfigurationProperties
public class FluentGithubModule implements EruptModule {

    public FluentGithubModule() {
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("fluent-github").build();
    }

    @Override
    public void run() {
        EruptModule.super.run();
    }

    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        menus.add(MetaMenu.createRootMenu("$github", "github管理", "fa fa-github", 1000));
        MetaMenu starredMenu = MetaMenu.createEruptClassMenu(GithubStarredRepo.class, menus.get(0), 0, MenuTypeEnum.TABLE);
        starredMenu.setIcon("fa fa-star");
        starredMenu.setName("github收藏");
        starredMenu.setCode("$github-starred");
        menus.add(starredMenu);

        MetaMenu awesomeModule = MetaMenu.createEruptClassMenu(AwesomeResource.class, menus.get(0), 1, MenuTypeEnum.TABLE);
        awesomeModule.setIcon("fa fa-font-awesome");
        awesomeModule.setName("awesomes");
        awesomeModule.setCode("$awesomes");
        menus.add(awesomeModule);

        MetaMenu trendingReposModule = MetaMenu.createEruptClassMenu(GithubTrendingRepo.class, menus.get(0), 2, MenuTypeEnum.TABLE);
        trendingReposModule.setIcon("fa fa-star");
        trendingReposModule.setName("github trending");
        trendingReposModule.setCode("$github-trending");
        menus.add(trendingReposModule);
        return menus;
    }

    static {
        EruptModuleInvoke.addEruptModule(FluentGithubModule.class);
    }
}
