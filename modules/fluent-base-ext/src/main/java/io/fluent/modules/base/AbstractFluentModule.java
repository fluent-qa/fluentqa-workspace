package io.fluent.modules.base;

import cn.hutool.core.util.ArrayUtil;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import java.util.List;

public abstract class AbstractFluentModule extends AbstractModule {

  @SuppressWarnings("unchecked")
  protected void bindPlugins(Class clazz) {
    try {
      Multibinder multibinder = Multibinder.newSetBinder(binder(), clazz);

      // add user configured plugins
      ClassLoader classLoader = AbstractFluentModule.class.getClassLoader();
      List<PluginSettings.PluginSetting> pluginSettings = PluginSettings.loadPlugins();
      pluginSettings.forEach(
          pluginSetting -> {
            Class aClass = null;
            try {
              aClass = classLoader.loadClass(pluginSetting.getClassName());
              if (ArrayUtil.contains(aClass.getInterfaces(), clazz)) {
                multibinder.addBinding().to(aClass);
              }
            } catch (ClassNotFoundException e) {
              throw new FluentModuleException("load plugin class failed,", e);
            }
          });
    } catch (Exception e) {
      throw new FluentModuleException("Binding of plugins failed");
    }
  }
}
