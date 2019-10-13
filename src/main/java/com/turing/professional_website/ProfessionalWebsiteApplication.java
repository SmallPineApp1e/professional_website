package com.turing.professional_website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class ProfessionalWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfessionalWebsiteApplication.class, args);
    }

}
