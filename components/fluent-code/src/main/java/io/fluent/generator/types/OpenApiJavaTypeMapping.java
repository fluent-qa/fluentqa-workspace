package io.fluent.generator.types;

import java.util.HashMap;
import java.util.Map;

public class OpenApiJavaTypeMapping implements TypeMapping{
    public static final HashMap<String, String> openapiTypeMap =new HashMap<String, String>();
    static {

        openapiTypeMap.put("bigint","integer");
        openapiTypeMap.put("int","integer");
        openapiTypeMap.put("tinyint","integer");
        openapiTypeMap.put("smallint","integer");
        openapiTypeMap.put("mediumint","integer");
        openapiTypeMap.put("integer","integer");
        openapiTypeMap.put("boolean","boolean");
        openapiTypeMap.put("float","number");
        openapiTypeMap.put("double","number");
        openapiTypeMap.put("decimal","Double");
    }
    @Override
    public Map<String, String> getTypeMapping() {
        return openapiTypeMap;
    }
}


