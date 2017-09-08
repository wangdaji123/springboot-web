package com.wangdj.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //spring加载该配置
@EnableSwagger2//启用Swagger2
//@Profile({ "dev", "test", "ntest" })
public class SwaggerConfiguration {
	public static final String CONTROLLER_PACKAGE = "com.wangdj.controller.user";
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))//显示该包下的内容
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
				.termsOfServiceUrl("http://blog.didispace.com/")
				.contact("wangdj")
				.version("1.0")
				.build();
	}
}
