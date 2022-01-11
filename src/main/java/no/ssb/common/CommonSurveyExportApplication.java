package no.ssb.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CommonSurveyExportApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonSurveyExportApplication.class, args);
    }
}
