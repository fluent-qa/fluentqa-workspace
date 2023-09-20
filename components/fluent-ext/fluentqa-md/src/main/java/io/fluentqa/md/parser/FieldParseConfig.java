package io.fluentqa.md.parser;

import lombok.Data;
import org.jsoup.nodes.Element;

import java.util.function.Function;

@Data
public class FieldParseConfig<T> {
        private String key;
        private Function<Element,T> extractFunc;
}
