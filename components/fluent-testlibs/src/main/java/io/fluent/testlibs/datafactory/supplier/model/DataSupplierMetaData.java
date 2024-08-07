package io.fluent.testlibs.datafactory.supplier.model;

import static io.fluent.testlibs.datafactory.supplier.utils.ReflectionUtils.invokeDataSupplier;
import static io.fluent.testlibs.datafactory.supplier.utils.ReflectionUtils.streamOf;
import static java.util.Collections.singletonList;
import static java.util.Optional.ofNullable;

import io.fluent.testlibs.datafactory.supplier.core.DataSupplier;
import io.fluent.testlibs.datafactory.supplier.utils.ReflectionUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Getter;
import one.util.streamex.EntryStream;
import one.util.streamex.IntStreamEx;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

/** Base container for DataSupplier meta data. */
public class DataSupplierMetaData {

  @Getter private final List<Object[]> testData;
  private final boolean transpose;
  private final boolean flatMap;
  private final int[] indices;
  @Getter private final TestNGMethod testNGMethod;

  public DataSupplierMetaData(final ITestContext context, final ITestNGMethod testMethod) {
    this.testNGMethod = new TestNGMethod(context, testMethod);
    this.transpose = testNGMethod.getDataSupplierArg(DataSupplier::transpose, false);
    this.flatMap = testNGMethod.getDataSupplierArg(DataSupplier::flatMap, false);
    this.indices = testNGMethod.getDataSupplierArg(DataSupplier::indices, new int[0]);
    this.testData = transform();
  }

  private List<Object[]> transform() {
    var returnValue = obtainReturnValue();
    var data = streamOf(returnValue).toList();
    var indicesList = indicesList(data.size());
    var wrappedReturnValue = EntryStream.of(data).filterKeys(indicesList::contains).values();

    if (transpose) {
      if (returnValue instanceof Collection || returnValue instanceof Map) {
        return singletonList(flatMap ? wrappedReturnValue.toArray() : new Object[] {returnValue});
      }
      return singletonList(
          flatMap
              ? wrappedReturnValue
                  .filter(Objects::nonNull)
                  .flatMap(ReflectionUtils::streamOf)
                  .toArray()
              : wrappedReturnValue.toArray());
    }

    return wrappedReturnValue
        .map(ob -> flatMap ? streamOf(ob).toArray() : new Object[] {ob})
        .toList();
  }

  private Object obtainReturnValue() {
    return invokeDataSupplier(testNGMethod.getDataSupplierMetaData());
  }

  private List<Integer> indicesList(final int collectionSize) {
    return ofNullable(indices)
        .filter(indicesArray -> indicesArray.length > 0)
        .map(IntStreamEx::of)
        .orElseGet(() -> IntStreamEx.range(0, collectionSize))
        .boxed()
        .toList();
  }
}
