package com.face.gmail.webutils.annotation;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FastFileRegister implements ImportSelector {

    @Override
    public final String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Map<String, Object> annotationAttributes =
                importingClassMetadata.getAnnotationAttributes(EnableFastFileStorage.class.getName());

        List<String> registerBeans = new ArrayList<>(2);

//        AnnotationAttributes enableWebSecurityAttrs = AnnotationAttributes
//                .fromMap(annotationAttributes);

        boolean open = (annotationAttributes == null
                ?  (boolean) AnnotationUtils.getDefaultValue(EnableFastFileStorage.class,"open")
                : (boolean) annotationAttributes.get("open"));

//        registerBeans.add(FileUploadTypeExcludeFilter.class.getName());

        if(open){
            registerBeans.add(FdfsClientConfig.class.getName());
        }

        return registerBeans.toArray(new String[0]);

    }
}
