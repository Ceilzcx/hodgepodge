package com.siesta.hodgepodge.dubbo.producer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.siesta.hodgepodge.dubbo")
public class Dubbo3ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo3ProducerApplication.class, args);
    }

}
