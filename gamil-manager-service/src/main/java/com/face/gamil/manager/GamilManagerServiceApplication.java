package com.face.gamil.manager;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDubboConfiguration
@SpringBootApplication
@MapperScan(basePackages = "com.face.gamil.manager.mapper")
public class GamilManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamilManagerServiceApplication.class, args);
    }

}

