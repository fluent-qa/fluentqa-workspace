package io.fluentqa.postman.model;

import lombok.Data;

import java.util.List;

@Data
public class PostmanScript {
    private List<String> exec;
    private String type;
}
