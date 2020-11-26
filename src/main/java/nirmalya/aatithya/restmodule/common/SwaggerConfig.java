package nirmalya.aatithya.restmodule.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("nirmalya.aatithya.restmodule"))

				.paths(PathSelectors.regex("/api/.*")).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Nirmalya AtithyA REST API").description("Nirmalya Atithya Mobile Rest Api Documentation")
				.contact(new Contact("Nirmalya Labs Team", "http://nirmalyalabs.com", "jineshbehera06@gmail.com"))
				.license("Nirmalya Lisence 2.0").licenseUrl("http://nirmalyalabs.com").version("1.0.0")
				.build();
	}

}
