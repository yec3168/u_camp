package com.ucamp.myspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**")
                // 반드시 url 끝에 '/'를 꼭 붙여줘야함.
                .addResourceLocations("classpath:/mobile/")
                .setCachePeriod(20);
    }

}
