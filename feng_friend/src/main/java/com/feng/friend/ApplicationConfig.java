package com.feng.friend;

import com.feng.friend.filter.JwtFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class ApplicationConfig extends WebMvcConfigurationSupport {

    private JwtFilter jwtFilter;

    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(jwtFilter).addPathPatterns("/**")
                .excludePathPatterns("/**/login");

    }

}
