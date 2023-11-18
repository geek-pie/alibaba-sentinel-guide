package com.xienng.okhttp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.xienng"})
public class Application {
    public static void main(String[] args) {
     SpringApplication.run(Application.class, args);
    }
}
