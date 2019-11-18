package com.turing.professional_website.configuration;

import com.turing.professional_website.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${teacher.requestImgPath}")
    private String requestTeacherImgPath;
    @Value("${team.requestImgPath}")
    private String requestTeamImgPath;
    @Value("${requestPdfPath}")
    private String requestPdfPath;
    @Value("${course.requestPPTPath}")
    private String requestPPTPath;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/teacher*")
                .addPathPatterns("/teacher/**")
                .addPathPatterns("/html/admin/*")
                .excludePathPatterns("/teacher/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(requestTeacherImgPath);
        System.out.println(requestTeamImgPath);
        System.out.println(requestPdfPath);
        System.out.println(requestPPTPath);

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
                .addResourceLocations(requestTeacherImgPath);

        registry.addResourceHandler("/static/team/**")
                .addResourceLocations(requestTeamImgPath);

        registry.addResourceHandler("/static/pdf/**")
                .addResourceLocations(requestPdfPath);

        registry.addResourceHandler("/static/ppt/**")
                .addResourceLocations(requestPPTPath);

        registry.addResourceHandler("/error/**")
                .addResourceLocations("classpath:/error/");

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
