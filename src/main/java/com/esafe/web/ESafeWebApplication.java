package com.esafe.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableSwagger2
public class ESafeWebApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(ESafeWebApplication.class);
	
	// start everything
    public static void main(String[] args) {
    	logger.error(".............EsafeWeb has started...........");
    	SpringApplication.run(ESafeWebApplication.class, args);
    }
    
    @Bean
    public Docket productApi() {
       return new Docket(DocumentationType.SWAGGER_2).select()
          .apis(RequestHandlerSelectors.basePackage("com.esafe.web")).build();
    }

}