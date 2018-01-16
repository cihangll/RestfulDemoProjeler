package com.cihangll.swaggerdemo.service;

import com.cihangll.swaggerdemo.domain.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);

	Product saveProduct(Product product);

	void deleteProduct(Integer id);
}
