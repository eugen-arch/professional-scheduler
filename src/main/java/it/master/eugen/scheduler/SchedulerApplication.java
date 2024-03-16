package it.master.eugen.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

    public static void main(final String[] args) {
	SpringApplication.run(SchedulerApplication.class, args);
    }

}
