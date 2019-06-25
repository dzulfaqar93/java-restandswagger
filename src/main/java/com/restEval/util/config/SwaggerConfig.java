package com.restEval.util.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket Api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.restEval"))
				.paths(PathSelectors.any())
				.build();
		
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "My REST API", 
	      "Some custom description of API.", 
	      "API TOS", 
	      "Terms of service", 
	      new Contact("Hilmy Dzul Faqar", "www.example.com", "myeaddress@company.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}
	
	
//	private ApiInfo apiInfo() {
//		   return new ApiInfoBuilder()
//				   .title("Swagger").description("Learn Swagger")
//	               .termsOfServiceUrl("http://springfox.io")
//	               .contact("Hilmy Dzul Faqar")
//	               .license("Apache License Version 2.0")
//	               .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
//	               .version("1.0")
//	               .build();
//		}
}
