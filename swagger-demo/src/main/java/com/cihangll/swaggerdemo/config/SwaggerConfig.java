package com.cihangll.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2 //Swagger Support Enabled.
public class SwaggerConfig {

	/**
	 * select() metodu ile Dockec Bean 'i için ApiSelectorBuilder instance çağırıyoruz.
	 * ApiSelectorBuilder ile birlikte;
	 * apis() - Swagger Dokümantasyon oluşturulacak apilerin bulunduğu package tanımı.
	 * paths() - apis() ile gelecek olan api sınıflarından path değeri şu olanların dokümantasyonu oluşsun.
	 * build() - ApiSelectorBuilder 'ı build edip Docket nesnemize işledik.
	 * apiInfo() - MetaData tanımı yapıp Docket nesnemize işledik.Bu sayede özelleştirmiş olduğumuz metadataya
	 * göre swagger-ui görüntülenecektir.
	 * <p>
	 * Artık swagger ui ye
	 * "http://localhost:8080/v2/api-docs"		- Swaggerın oluşturmuş olduğu dokümantasyonun JSON hali.
	 * "http://localhost:8080/swagger-ui.html"	- Swaggerın oluşturmuş olduğu dokümantasyonun HTML hali.
	 * erişebilriz.
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.cihangll.swaggerdemo.controller"))
				.paths(regex("/product.*"))
				.build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API Swagger Deneme Projesi",
				"1.0",
				"Term of service",
				new Contact("Cihan Güllü", "http://www.cihangullu.com", "cihangullu54@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licences/LICENSE-2.0"
		);
		return apiInfo;
	}
}

/*

Spring Boot kullanmıyorsak,spring framework için kullanılabilecek konfügürasyon hali şu şekilde olacaktır.
Docket nesnesi örneğinde bir değişiklik yok.Fakat bu sınıfı "WebMvcConfigurationSupport" sınıfından extend edip,
bu sınıf ile birlikte gelen "addResourceHandler" metoduna url ve bu sınıfın kullanacağı resource sınıfının yerini
belirtmemiz gerekir.

 //WebMvcConfigurerAdapter - spring 4 ve altındaki versiyonlar için
 //WebMvcConfigurerAdapter depraced olduktan sonra yerine gelen, spring 5 versiyonu için WebMvcConfigurationSupport


@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("guru.springframework"))
				.paths(regex("/api/v1/*"))
				.build();

	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
*/
