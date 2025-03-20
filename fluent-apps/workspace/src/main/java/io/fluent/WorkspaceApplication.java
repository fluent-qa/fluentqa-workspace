package io.fluent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import xyz.erupt.core.annotation.EruptScan;

@SpringBootApplication
@EnableAsync
@EruptScan
@EntityScan
public class WorkspaceApplication {
    /**
     * QA Management Application Entrypoint
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WorkspaceApplication.class);
    }
}
