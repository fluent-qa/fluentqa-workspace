package io.fluent.testlibs.datafactory.supplier.core;

import io.fluent.testlibs.datafactory.supplier.model.DataSupplierMetaData;
import java.util.Collection;
import java.util.Collections;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

/**
 * A listener which allows retrieving useful meta-data. Should be implemented on client side, and
 * linked via SPI.
 */
public interface DataSupplierInterceptor {

  default void beforeDataPreparation(final ITestContext context, final ITestNGMethod method) {
    // not implemented
  }

  default void afterDataPreparation(final ITestContext context, final ITestNGMethod method) {
    // not implemented
  }

  default void onDataPreparation(final DataSupplierMetaData metaData) {
    // not implemented
  }

  default Collection<DataSupplierMetaData> getMetaData() {
    return Collections.emptyList();
  }
}
