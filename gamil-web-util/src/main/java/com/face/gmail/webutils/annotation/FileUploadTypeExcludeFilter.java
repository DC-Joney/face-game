package com.face.gmail.webutils.annotation;

import com.face.gmail.webutils.web.FileUploadController;
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileUploadTypeExcludeFilter extends TypeExcludeFilter {

    private BeanFactory beanFactory;

    private static final Map<String, Boolean> excludeCache = new ConcurrentHashMap<>(32);

    private static final String excludeClassName = FileUploadController.class.getName();

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        super.setBeanFactory(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        try {

            String className = metadataReader.getClassMetadata().getClassName();

            Boolean excludeState = excludeCache.computeIfAbsent(className, n -> n.equals(excludeClassName));

            if(excludeState){
                beanFactory.getBean(FdfsClientConfig.class);
            }

        } catch (NoSuchBeanDefinitionException e) {
            return true;
        }

        return false;
    }
}
