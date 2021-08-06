package com.example.demo.config;

import com.example.demo.interceptor.OneInterceptor;
import com.example.demo.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义两个拦截器
        // 指定某个路径只让后面拦截器处理
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/**").excludePathPatterns("/{uid}/test2");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/{uid}/test2");
    }
}
