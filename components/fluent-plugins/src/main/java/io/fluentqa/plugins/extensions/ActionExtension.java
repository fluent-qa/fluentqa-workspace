package io.fluentqa.plugins.extensions;

import org.pf4j.ExtensionPoint;

public interface ActionExtension<T> extends ExtensionPoint {

    T action();
}
