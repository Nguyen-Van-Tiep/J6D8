package com.j6d8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.j6d8.intercoptor.GlobalIntercoptor;

@Configuration
public class IntercoptorConfig implements WebMvcConfigurer {
    @Autowired
    GlobalIntercoptor globalIntercoptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalIntercoptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
    }

}
