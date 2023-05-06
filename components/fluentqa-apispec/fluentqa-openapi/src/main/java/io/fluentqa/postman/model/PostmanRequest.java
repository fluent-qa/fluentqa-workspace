package io.fluentqa.postman.model;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PostmanRequest {

    private String method;
    private String schema;
    private List<PostmanKeyValue> header;
    private PostmanBody body;
    private PostmanQuery query;
    private Map<String,Object> auth;
    private PostmanUrl url;
    private String description;
}
