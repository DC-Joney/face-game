package com.face.gmail.order;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class GmailOrderWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmailOrderWebApplication.class, args);
    }

}

