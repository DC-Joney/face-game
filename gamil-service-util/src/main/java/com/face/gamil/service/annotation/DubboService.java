package com.face.gamil.service.annotation;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Component
public @interface DubboService {
}
