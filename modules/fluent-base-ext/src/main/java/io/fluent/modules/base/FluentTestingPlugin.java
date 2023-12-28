package io.fluent.modules.base;

public interface FluentTestingPlugin {
    void beforeAllTests();

    void afterAllTests();

    void beforeScenario();

    void afterScenario();
}
