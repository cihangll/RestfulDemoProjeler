package com.cihangll.swaggerdemo.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Normally, you’d configure the H2 database in the web.xml file as a servlet,
 * but Spring Boot is going to use an embedded instance of Tomcat, so we don’t
 * have access to the web.xml file. Spring Boot does provide us a mechanism to
 * use for declaring servlets via a Spring Boot ServletRegistrationBean.
 *
 * Normalde H2 database konfigürasyon işlemini web.xml dosyası içerisinde servlet tanımlayarak yaparız.
 * Fakat spring-boot web jarı ile birlikte gelen gömülü Tomcat server kullandığımız
 * için bunu doğrudan yapamayız.Bunun için Spring Boot servlet tanımı yapabileceğiz "ServletRegistrationBean"
 * mekanizmasını sağlar.
 *
 *
 * Eğer H2 database console ile birlikte "Spring Security" kullanmıyorsak,H2 database console'u
 * çalıştırmamız için gereken konfigürasyon işlemi bu kadar.
 *
 * -- http://localhost:8080/console
 *
 * Server Adı : "jdbc:h2:mem:testdb" şeklinde olması gerek.Default olarak geleni buna setle.
 *
 * adresinden ulaşabiliriz.
 *
 * Spring Security kullanıyorsak ilgili açıklamaları SecurityConfig kısmında.
 *
 */
@Configuration
public class WebConfig {

	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
