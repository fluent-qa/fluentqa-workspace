package io.fluent.generator.types;

import io.fluent.generator.exception.TypeMappingException;
import lombok.Data;


import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class TypeMappings {

    private  Map<String, Map<String, String>> typeMappings = new ConcurrentHashMap<>();

    public TypeMappings(){
        typeMappings.put("postgre-java", new PostgreSqlJavaTypeMapping().getTypeMapping());
        typeMappings.put("mysql-java", new MySqlJavaTypeMapping().getTypeMapping());
        typeMappings.put("openapi-java", new OpenApiJavaTypeMapping().getTypeMapping());
    }

    public  Map<String, String> getTypeMapping(String typeMappingName) {
        if (typeMappings.get(typeMappingName) == null) {
            throw new TypeMappingException();
        }
        return typeMappings.get(typeMappingName);
    }

    public TypeMappings registerTypeMapping(String typeMappingName,Map<String,String> languageTypeMappings){
        typeMappings.put(typeMappingName,languageTypeMappings);
        return this;
    }

    public Set<String> getTypeMappingNames(){
        return typeMappings.keySet();
    }
}
