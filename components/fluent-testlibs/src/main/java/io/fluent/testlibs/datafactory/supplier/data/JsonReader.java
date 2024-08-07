package io.fluent.testlibs.datafactory.supplier.data;

import static com.google.gson.JsonParser.parseReader;
import static io.vavr.API.*;
import static java.lang.String.format;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.fluent.testlibs.datafactory.supplier.utils.ReflectionUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import one.util.streamex.StreamEx;

@AllArgsConstructor
public class JsonReader<T> implements DataReader<T> {

  @Getter private final Class<T> entityClass;
  @Getter private final String path;

  public JsonReader(final Class<T> entityClass) {
    this(entityClass, "");
  }

  public StreamEx<T> read() {
    var gson = new Gson();
    try (var streamReader = new InputStreamReader(getUrl().openStream(), StandardCharsets.UTF_8);
        var jsonReader = new com.google.gson.stream.JsonReader(streamReader)) {
      return Match(parseReader(jsonReader))
          .of(
              Case(
                  $(JsonElement::isJsonArray),
                  j -> StreamEx.of(gson.fromJson(j, ReflectionUtils.castToArray(entityClass)))),
              Case(
                  $(),
                  j -> StreamEx.of(gson.fromJson(j, ReflectionUtils.castToObject(entityClass)))));
    } catch (IOException ex) {
      throw new IllegalArgumentException(
          format("Unable to read JSON data to %s. Check provided path.", entityClass), ex);
    }
  }
}
