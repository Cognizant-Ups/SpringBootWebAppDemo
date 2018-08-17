package com.cts.devops.demo.services;

import com.cts.devops.demo.domain.Product;
import com.cts.devops.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Product service.
 */
@Service
public class ProductServiceImpl implements ProductService {
    /**
     * The Product repository.
     */
    private ProductRepository productRepository;

    /**
     * Sets product repository.
     *
     * @param productRepository the product repository
     */
    @Autowired
    public void setProductRepository(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
