package com.face.gmail.webutils.listener;

import com.face.gmail.webutils.annotation.FileUploadTypeExcludeFilter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationLoadedListener implements ApplicationListener<ApplicationPreparedEvent>{

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        if(event.getApplicationContext() instanceof GenericApplicationContext){
            GenericApplicationContext registry = (GenericApplicationContext) event.getApplicationContext();

            BeanDefinitionBuilder builder =
                    BeanDefinitionBuilder.genericBeanDefinition(FileUploadTypeExcludeFilter.class)
                            .setRole(BeanDefinition.ROLE_INFRASTRUCTURE)
                            .setAutowireMode(AbstractBeanDefinition.AUTOWIRE_NO);

            BeanDefinition beanDefinition = builder.getBeanDefinition();
            registry.registerBeanDefinition(FileUploadTypeExcludeFilter.class.getName(),
                    beanDefinition);

        }
    }
}

