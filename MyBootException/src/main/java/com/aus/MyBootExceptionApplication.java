package com.aus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MyBootExceptionApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyBootExceptionApplication.class, args);
    }

}
