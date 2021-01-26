package com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig   implements WebMvcConfigurer {
 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(info())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.itau"))
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false);
	}

	private ApiInfo info() {
		return new ApiInfoBuilder().title("API - STAR WARS Films")
				.description(description())
				.termsOfServiceUrl("")
				.version("0.0.1")
				.build();
	}
	
	private String description() {
		StringBuilder str = new StringBuilder();
		str.append("Esta documentação foi criada através da biblioteca do Swagger demonstrando ");
		str.append("no teste como usar a documentação criada em tempo de desenvolvimento.");
		return str.toString();

	}
	
}