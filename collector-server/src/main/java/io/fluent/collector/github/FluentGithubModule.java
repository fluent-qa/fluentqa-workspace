package io.fluent.collector.github;

import io.fluent.collector.github.model.GithubStarredRepo;
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
import xyz.erupt.upms.EruptUpmsAutoConfiguration;

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
        List<MetaMenu> menus = new ArrayList();
        menus.add(MetaMenu.createRootMenu("$github", "github管理", "fa fa-github", 1));
        MetaMenu starredMenu =MetaMenu.createEruptClassMenu(GithubStarredRepo.class, menus.get(0), 0, MenuTypeEnum.TABLE);
        starredMenu.setIcon("fa fa-star");
        starredMenu.setName("github收藏");
        starredMenu.setCode("$github-starred");
        menus.add(starredMenu);
        return menus;
    }

    static {
        EruptModuleInvoke.addEruptModule(FluentGithubModule.class);
    }
}
