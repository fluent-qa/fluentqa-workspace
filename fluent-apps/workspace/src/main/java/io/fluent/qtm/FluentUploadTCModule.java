package io.fluent.qtm;

import io.fluent.qtm.upload.model.UploadFileModel;
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
public class FluentUploadTCModule implements EruptModule {

    public FluentUploadTCModule() {
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("fluent-tc-sync").build();
    }

    @Override
    public void run() {
        EruptModule.super.run();
    }

    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        menus.add(MetaMenu.createRootMenu("$tc-upload", "测试文件管理", "fa fa-file", 100));
        MetaMenu tfUploadSyncMenu = MetaMenu.createEruptClassMenu(UploadFileModel.class, menus.get(0), 0, MenuTypeEnum.TABLE);
        tfUploadSyncMenu.setIcon("fa fa-folder-open");
        tfUploadSyncMenu.setName("测试文件同步");
        tfUploadSyncMenu.setCode("$tc-upload-sync");
        menus.add(tfUploadSyncMenu);
        return menus;
    }

    static {
        EruptModuleInvoke.addEruptModule(FluentUploadTCModule.class);
    }
}
