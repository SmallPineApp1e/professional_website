package com.turing.professional_website.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jack
 * @date 2019-03-27-18:54
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket guestControllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("前台用户API接口文档")
                .apiInfo(new ApiInfoBuilder()
                        .title("图灵二轮考核接口文档")
                        .description("用于前台用户获取精品网站的各种信息")
                        .contact(new Contact("蒙家辉 曾智杰 ",null, "jie534838094@163.com "))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.turing.professional_website.controller.guest"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket adminControllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台管理API接口文档")
                .apiInfo(new ApiInfoBuilder()
                        .title("精品网站后台管理接口文档")
                        .description("用于精品课程网站的各项信息管理")
                        .contact(new Contact("蒙家辉 曾智杰 ",null, "jie534838094@163.com"))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.turing.professional_website.controller.admin"))
                .paths(PathSelectors.any())
                .build();
    }

}
