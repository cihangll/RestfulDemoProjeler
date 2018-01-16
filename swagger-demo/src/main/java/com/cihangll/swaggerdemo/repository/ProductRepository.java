package com.cihangll.swaggerdemo.repository;

import com.cihangll.swaggerdemo.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer>{
}
