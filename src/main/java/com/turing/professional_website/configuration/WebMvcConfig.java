package com.turing.professional_website.configuration;

import com.turing.professional_website.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jack
 * @date 2019-06-26-22:19
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/teacher*")
                .addPathPatterns("/teacher/*")
                .addPathPatterns("/html/admin/*")
                .excludePathPatterns("/teacher/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/html/**")
                .addResourceLocations("classpath:/html/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/static/js/**")
                .addResourceLocations("classpath:/static/js/");

        registry.addResourceHandler("/static/css/**")
                .addResourceLocations("classpath:/static/css/");

        registry.addResourceHandler("/static/img/**")
                .addResourceLocations("classpath:/static/img/");

        registry.addResourceHandler("/static/fonts/**")
                .addResourceLocations("classpath:/static/fonts/");

        registry.addResourceHandler("/static/icon/**")
                .addResourceLocations("classpath:/static/icon/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
