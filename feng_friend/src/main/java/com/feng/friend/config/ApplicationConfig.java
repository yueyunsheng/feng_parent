package com.feng.friend.config;

import com.feng.friend.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {


    @Autowired
    private JwtFilter jwtFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(jwtFilter).addPathPatterns("/**")
                .excludePathPatterns("/**/login");

    }

    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }

}
