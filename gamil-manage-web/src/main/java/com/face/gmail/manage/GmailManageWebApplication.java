package com.face.gmail.manage;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.face.gmail.webutils.config.ExcludeFilterConfiguration;
import com.face.gmail.webutils.WebUtilsConfig;
import com.face.gmail.webutils.annotation.EnableFastFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@EnableDubboConfiguration
@EnableFastFileStorage
@SpringBootApplication
@Import({WebUtilsConfig.class, ExcludeFilterConfiguration.class})
// 解决jmx重复注册bean的问题
public class GmailManageWebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GmailManageWebApplication.class);
//        application.addListeners(new ApplicationLoadedListener());
        application.run(args);
    }


}
