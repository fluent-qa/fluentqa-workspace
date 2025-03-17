package io.fluentqa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import xyz.erupt.core.annotation.EruptScan;

@SpringBootApplication
@EnableAsync
@EruptScan
@EntityScan
public class QAWorkspaceApp {
    public static void main(String[] args) {
        SpringApplication.run(QAWorkspaceApp.class);
    }
}
