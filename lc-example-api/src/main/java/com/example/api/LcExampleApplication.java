package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application
 *
 * @author cliang
 * @createdate 2020年7月20日
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableAsync
public class LcExampleApplication {

    /**
     * main
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(LcExampleApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
