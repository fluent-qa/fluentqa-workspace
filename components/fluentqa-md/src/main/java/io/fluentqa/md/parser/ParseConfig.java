package io.fluentqa.md.parser;

import cn.hutool.core.util.ReflectUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class ParseConfig<T> {
    private List<FieldParseConfig<T>> configs =new ArrayList<>();
    private ConcurrentHashMap<String,FieldParseConfig<T>> configMap;

    public void flat(){
        for (FieldParseConfig<T> config : configs) {
            ReflectUtil.setFieldValue(this,config.getKey(),config);
        }
    }
}
