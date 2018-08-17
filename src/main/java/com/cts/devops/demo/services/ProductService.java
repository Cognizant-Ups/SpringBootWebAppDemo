package com.cts.devops.demo.services;


import com.cts.devops.demo.domain.Product;

/**
 * The interface Product service.
 */
public interface ProductService {
    /**
     * List all products iterable.
     *
     * @return the iterable
     */
    Iterable<Product> listAllProducts();

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    Product getProductById(Integer id);

    /**
     * Save product product.
     *
     * @param product the product
     * @return the product
     */
    Product saveProduct(Product product);
}
