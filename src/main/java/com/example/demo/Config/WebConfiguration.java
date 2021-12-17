package com.example.demo.Config;

import com.example.demo.Auth.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private AuthInterceptor authInterceptor;

    @Autowired
    public void setAuthInterceptor(AuthInterceptor authInterceptor){
        this.authInterceptor = authInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/error");
    }
}
