package io.fluentqa.qtm;


import io.fluentqa.qtm.api.model.*;
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
        return ModuleInfo.builder().name("fluent-api").build();
    }

    @Override
    public void run() {
        EruptModule.super.run();
    }

    /**
     * API管理：
     * <p>
     * 1. API 仓库管理
     * 2. API 接口定义
     * 3. API 接口录制记录
     * 4. API 接口测试
     *
     * @return
     */
    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        menus.add(MetaMenu.createRootMenu("$APIMgr", "接口管理", "fa fa-exchange", 1));

        MetaMenu menuForAdded = MetaMenu.createEruptClassMenu(RemoteApi.class,
                menus.get(0), 1, MenuTypeEnum.TABLE);
        menuForAdded.setIcon("fa fa-scissors");
        menuForAdded.setName("API清单");
        menuForAdded.setCode("$API-List");
        menus.add(menuForAdded);

        MetaMenu rawApiTestCaseMenu = MetaMenu.createEruptClassMenu(RawApiTestCase.class,
                menus.get(0), 1, MenuTypeEnum.TABLE);
        rawApiTestCaseMenu.setIcon("fa fa-scissors");
        rawApiTestCaseMenu.setName("API生成原始测试用例");
        rawApiTestCaseMenu.setCode("$API-TC-GEN");
        menus.add(rawApiTestCaseMenu);

        MetaMenu apiMonitorRecordMenu = MetaMenu.createEruptClassMenu(ApiMonitorRecord.class,
                menus.get(0), 2, MenuTypeEnum.TABLE);
        apiMonitorRecordMenu.setIcon("fa fa-repeat");
        apiMonitorRecordMenu.setName("API录制记录");
        apiMonitorRecordMenu.setCode("$API-Record");
        menus.add(apiMonitorRecordMenu);

        MetaMenu apiTestRecord = MetaMenu.createEruptClassMenu(
                ApiTestRecord
                        .class,
                menus.get(0), 3, MenuTypeEnum.TABLE);
        apiTestRecord.setIcon("fa fa-thumbs-up");
        apiTestRecord.setName("API测试结果记录");
        apiTestRecord.setCode("$API-TestResult");
        menus.add(apiTestRecord);

        MetaMenu apiTestScenarioMenu = MetaMenu.createEruptClassMenu(
                ApiTestScenario
                        .class,
                menus.get(0), 4, MenuTypeEnum.TABLE);
        apiTestScenarioMenu.setIcon("fa fa-folder");
        apiTestScenarioMenu.setName("API测试场景");
        apiTestScenarioMenu.setCode("$API-TestScenario");
        menus.add(apiTestScenarioMenu);

        MetaMenu apiStepMenu = MetaMenu.createEruptClassMenu(
                ApiStep
                        .class,
                menus.get(0), 5, MenuTypeEnum.TABLE);
        apiStepMenu.setIcon("fa fa-folder");
        apiStepMenu.setName("API用例步骤");
        apiStepMenu.setCode("$API-Step");
        menus.add(apiStepMenu);
//        MetaMenu apiDefMenu = MetaMenu.createSimpleMenu("$API-def", "接口定义", "fa fa-check-square-o",
//                menus.get(0), 1, "");
//        menus.add(apiDefMenu);
//        addNewMenu(
//                menus,"$API-Spec-Git","API定义仓库", "fa fa-meetup", ApiSpecGitRepoModel.class,
//                MenuTypeEnum.TABLE,1,0
//        );
//        addNewMenu(
//                menus,"$API-Spec","API最新版本", "fa fa-gitlab", ApiSpecVersionModel.class,
//                MenuTypeEnum.TABLE,1,1
//        );

        return menus;
    }


    static {
        EruptModuleInvoke.addEruptModule(FluentQAApiModule.class);
    }

    @Override
    public void initFun() {
        EruptModule.super.initFun();
    }
}
