package com.siesta.hodgepodge.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Dubbo3ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo3ConsumerApplication.class, args);
    }

}
