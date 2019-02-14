package com.face.gamil.usermanage;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDubboConfiguration
@SpringBootApplication
@MapperScan(basePackages = "com.face.gamil.usermanage.mapper")
public class GamilUsermanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamilUsermanageApplication.class, args);
    }

}

