package com.catface.eden.http.config.swagger;

import com.catface.common.enums.common.EnvironmentConst;

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

/**
 * @author catface
 * @date 2018/3/6
 */
@Configuration
@EnableSwagger2
@Profile({EnvironmentConst.LOCAL, EnvironmentConst.DEV})
public class Swagger2Config {

	@Bean
	public Docket createRestWebApi() {
		return new Docket(DocumentationType.SWAGGER_2)
						.groupName("web.eden")
						.apiInfo(apiInfo())
						.select()
						// 扫描的包所在位置
						.apis(RequestHandlerSelectors.basePackage("com.catface.eden.http.web"))
						// 扫描的 URL 规则
						.paths(PathSelectors.any())
						.build();
	}

	@Bean
	public Docket createRestRpcApi() {
		return new Docket(DocumentationType.SWAGGER_2)
						.groupName("rpc.eden")
						.apiInfo(apiInfo())
						.select()
						// 扫描的包所在位置
						.apis(RequestHandlerSelectors.basePackage("com.catface.eden.http.rpc"))
						// 扫描的 URL 规则
						.paths(PathSelectors.any())
						.build();
	}

	private ApiInfo apiInfo() {
		// 联系信息
		return new ApiInfoBuilder()
						// 大标题
						.title("catface小店")
						// 描述
						.description("catface小店")
						// 版本
						.version("0.0.1-SNAPSHOT")
						.build();
	}
}
