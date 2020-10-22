package com.example.api.dictionary.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.List;

/**
 * 配置拦截器
 *
 * @author cliang
 * @createdate 2020年10月22日
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    /**
     * 拦截器配置
     *
     * @param registry
     * @Title: addInterceptors
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**",
                        "/swagger-ui.html/**");
    }

    /**
     * 解决跨域问题
     *
     * @param registry
     * @Title: addCorsMappings
     * @author: cliang
     * @version 创建时间：2020年10月22日
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE", "GET", "POST")
                .allowedHeaders("*")
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options",
                        "token",
                        "timestamp",
                        "sign")
                .allowCredentials(false).maxAge(3600);
    }

}