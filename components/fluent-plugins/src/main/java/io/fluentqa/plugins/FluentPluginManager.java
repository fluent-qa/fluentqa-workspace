package io.fluentqa.plugins;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginFactory;

public class FluentPluginManager extends DefaultPluginManager {
    @Override
    protected PluginFactory createPluginFactory() {
        return new FluentPluginFactory();
    }
}
