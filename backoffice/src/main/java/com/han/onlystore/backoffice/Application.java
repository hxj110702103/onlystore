package com.han.onlystore.backoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.lang.invoke.MethodHandles;

/**
 * Created by apple on 2017/2/19.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.han.onlystore, ch.ralscha.extdirectspring")
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableScheduling
public class Application {
    public static final Logger logger = LoggerFactory
            .getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        // -Dspring.profiles.active=dev
        SpringApplication.run(Application.class, args);
    }
}