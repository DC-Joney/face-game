package com.face.gmail.webutils;

import com.face.gmail.webutils.annotation.FileUploadTypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = FileUploadTypeExcludeFilter.class)})
public class WebUtilsConfig {



}
