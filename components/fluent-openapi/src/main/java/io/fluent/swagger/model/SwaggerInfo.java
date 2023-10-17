package io.fluent.swagger.model;

import lombok.Data;

@Data
public class SwaggerInfo {
    private String version;
    private String title;
    private String description;
    private String termsOfService;
}
