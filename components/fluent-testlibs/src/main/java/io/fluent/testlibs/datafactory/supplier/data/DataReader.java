package io.fluent.testlibs.datafactory.supplier.data;

import static io.fluent.testlibs.datafactory.supplier.utils.ReflectionUtils.getSourcePath;

import java.io.IOException;
import java.net.URL;
import one.util.streamex.StreamEx;

public interface DataReader<T> {

  StreamEx<T> read();

  Class<T> getEntityClass();

  String getPath();

  default URL getUrl() throws IOException {
    return getPath().isEmpty() ? getSourcePath(getEntityClass()) : getSourcePath(getPath());
  }
}
