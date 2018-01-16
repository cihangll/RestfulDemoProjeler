package com.cihangll.jersey.config;

import com.cihangll.jersey.service.NotFoundExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.NotFoundException;

@Configuration
@ApplicationPath("/")
//ya da yalnızca @Component diyebiliriz.
public class JerseyConfiguration extends ResourceConfig {

	//NOTLAR:

	/**
	 * @Consumes -> Methodun kabul edeceği MIME type’ı ayarlamaya yarar. Bunlardan bir kaçı; json, xml, text vs.
	 * @Produces -> Methodun üreteceği MIME type’ı ayarlamaya yarar.
	 */

	public JerseyConfiguration() {
		packages("com.cihangll.jersey.resource");
		//Bu sınıfı bulamayınca hata veriyor.Jersey sunucusuna eklememiz gerek.
		register(NotFoundExceptionMapper.class);
	}
}
