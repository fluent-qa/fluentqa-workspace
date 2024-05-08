package io.fluentqa.qtm.api;


import io.fluentqa.github.FluentGithubModule;
import io.fluentqa.github.model.GithubStarredRepo;
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
public class FluentQAApiModule implements EruptModule {
    public FluentQAApiModule() {
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("QA-API").build();
    }

    @Override
    public void run() {
        EruptModule.super.run();
    }

    /**
     * API管理：
     *
     *  1. API 仓库管理
     *  2. API 接口定义
     *  3. API 接口录制记录
     *  4. API 接口测试
     * @return
     */
    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        menus.add(MetaMenu.createRootMenu("$APIMgr", "接口管理", "fa-exchange", 1));
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

    @Override
    public void initFun() {
        EruptModule.super.initFun();
    }
}
