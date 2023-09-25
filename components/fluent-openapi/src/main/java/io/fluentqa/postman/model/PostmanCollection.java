package io.fluentqa.postman.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PostmanCollection {

    private PostmanCollectionInfo info;
    private List<PostmanItem> item;
    private List<PostmanKeyValue> variable;
    private Map<String,Object> auth;
}
