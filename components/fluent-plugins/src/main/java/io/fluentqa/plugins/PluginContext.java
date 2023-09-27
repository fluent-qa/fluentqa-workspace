package io.fluentqa.plugins;

import org.pf4j.RuntimeMode;

public class PluginContext {

    private final RuntimeMode runtimeMode;

    public PluginContext(RuntimeMode runtimeMode) {
        this.runtimeMode = runtimeMode;
    }

    public RuntimeMode getRuntimeMode() {
        return runtimeMode;
    }

}