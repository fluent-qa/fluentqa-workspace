package io.fluent.base;

import io.fluent.base.masterdata.model.MasterData;
import io.fluent.base.product.model.ProductModuleModel;
import io.fluent.base.project.model.ProjectModel;
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
public class FluentProductConfigModule implements EruptModule {

    public FluentProductConfigModule() {
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("fluent-product").build();
    }

    @Override
    public void run() {
        EruptModule.super.run();
    }

    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        menus.add(MetaMenu.createRootMenu("$fluent-master", "产品配置", "fa fa-product-hunt", 90));
        MetaMenu productMetaMenu = MetaMenu.createEruptClassMenu(ProductModuleModel.class, menus.get(0), 0, MenuTypeEnum.TABLE);
        productMetaMenu.setIcon("fa fa-group");
        productMetaMenu.setName("产品元数据");
        productMetaMenu.setCode("$product-meta");
        menus.add(productMetaMenu);
        MetaMenu masterDataMenu = MetaMenu.createEruptClassMenu(MasterData.class, menus.get(0), 1, MenuTypeEnum.TABLE);
        masterDataMenu.setIcon("fa fa-times");
        masterDataMenu.setName("产品字典表配置");
        masterDataMenu.setCode("$master-data");
        menus.add(masterDataMenu);
        MetaMenu projectMenu = MetaMenu.createEruptClassMenu(ProjectModel.class, menus.get(0), 2, MenuTypeEnum.TABLE);
        projectMenu.setIcon("fa fa-linode");
        projectMenu.setName("项目配置");
        projectMenu.setCode("$project-meta");
        menus.add(projectMenu);
        return menus;
    }

    static {
        EruptModuleInvoke.addEruptModule(FluentProductConfigModule.class);
    }
}
