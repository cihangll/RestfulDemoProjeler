package com.cihangll.swaggerdemo.bootstrap;

import com.cihangll.swaggerdemo.domain.Product;
import com.cihangll.swaggerdemo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
/**
 * ApplicationListener yaptık.Spring Context container ımız her refresh olduğunda onApplicationEvent() ile birlikte bu sınıf ayağa kalkacaktır.
 * Örneğin proje başlatıldığında onApplicationEvent() ile birlikte bu sınıf ayaga kalkar.
 */
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	/**
	 * Context container ımız oluşturulduğunda ya da refresh edildiğinde çağrılacak olan metot.
	 */
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProducts();
	}

	private void loadProducts() {

		Product product1 = new Product();
		product1.setDescription("description 1");
		product1.setPrice(new BigDecimal("214.14"));
		product1.setImageUrl("https://spring.io/img/spring-by-pivotal-9066b55828deb3c10e27e609af322c40.png");
		product1.setProductId("5132512");
		productRepository.save(product1);

		logger.info("Saved product1 - id :" + product1.getId());

		Product product2 = new Product();
		product2.setDescription("description 2");
		product2.setPrice(new BigDecimal("4.15614"));
		product2.setImageUrl("https://spring.io/img/spring-by-pivotal-9066b55828deb3c10e27e609af322c40.png");
		product2.setProductId("5414124");
		productRepository.save(product2);

		logger.info("Saved product1 - id :" + product2.getId());
	}
}
