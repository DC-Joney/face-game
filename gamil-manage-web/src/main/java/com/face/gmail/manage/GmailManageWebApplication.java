package com.face.gmail.manage;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class GmailManageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmailManageWebApplication.class, args);
    }


}
