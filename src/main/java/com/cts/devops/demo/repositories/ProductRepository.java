package com.cts.devops.demo.repositories;

import com.cts.devops.demo.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
}
