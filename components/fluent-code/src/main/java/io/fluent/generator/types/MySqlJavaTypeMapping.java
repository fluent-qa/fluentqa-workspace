package io.fluent.generator.types;

import java.util.HashMap;
import java.util.Map;


public final class MySqlJavaTypeMapping implements TypeMapping{
    public static final  HashMap<String, String> javaTypeMap = new HashMap<String, String>();

    static{
        javaTypeMap.put("bigint","Long");
        javaTypeMap.put("int","Integer");
        javaTypeMap.put("tinyint","Integer");
        javaTypeMap.put("smallint","Integer");
        javaTypeMap.put("mediumint","Integer");
        javaTypeMap.put("integer","Integer");
        //小数
        javaTypeMap.put("float","Float");
        javaTypeMap.put("double","Double");
        javaTypeMap.put("decimal","Double");
        //bool
        javaTypeMap.put("bit","Boolean");
        //字符串
        javaTypeMap.put("char","String");
        javaTypeMap.put("varchar","String");
        javaTypeMap.put("tinytext","String");
        javaTypeMap.put("text","String");
        javaTypeMap.put("mediumtext","String");
        javaTypeMap.put("longtext","String");
        //日期
        javaTypeMap.put("date","Date");
        javaTypeMap.put("datetime","Date");
        javaTypeMap.put("timestamp","Date");

    }

    @Override
    public Map<String, String> getTypeMapping() {
        return javaTypeMap;
    }
}
