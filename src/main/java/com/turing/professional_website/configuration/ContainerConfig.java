package com.turing.professional_website.configuration;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jack
 * @date 2019-06-30-16:07
 * 根据错误状态码映射错误页面
 */
@Configuration
public class ContainerConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactory(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                Set<ErrorPage> errorPages = new HashSet<ErrorPage>();
                errorPages.add(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html"));
                errorPages.add(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html"));
                factory.setErrorPages(errorPages);
            }
        };
    }

}
