package com.face.gmail.webutils.annotation;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastFileRegister.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public @interface EnableFastFileStorage {

    boolean open() default true;

}
