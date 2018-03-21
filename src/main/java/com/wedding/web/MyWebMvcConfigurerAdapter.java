package com.wedding.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by sangyuqi on 2018/3/21.
 */
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    /**
     * 重写拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * 资源控制器
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //通过addResourceHandler添加映射路径 通过addResourceLocations来指定路径
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/META-INF/resources/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
