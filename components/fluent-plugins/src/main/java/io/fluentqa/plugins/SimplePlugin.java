package io.fluentqa.plugins;

import org.pf4j.Plugin;

public abstract class SimplePlugin extends Plugin {
    protected final PluginContext context;
    protected SimplePlugin(PluginContext context) {
        super();

        this.context = context;
    }
}
