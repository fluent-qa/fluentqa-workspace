package io.fluentqa.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import xyz.erupt.core.annotation.EruptScan;

@SpringBootApplication
@EntityScan(basePackages = {"io.fluentqa"})
@EruptScan
@EnableAsync
@ComponentScan(basePackages = {"io.fluentqa"})
public class QAWorkspaceApp {
    public static void main(String[] args) {
        SpringApplication.run(QAWorkspaceApp.class);
    }
}
