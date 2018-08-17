package com.cts.devops.demo.repositories;

import com.cts.devops.demo.configuration.RepositoryConfiguration;
import com.cts.devops.demo.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * The type Product repository test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {

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

    /**
     * Test save product.
     */
    @Test
    public void testSaveProduct(){
        //setup product
        Product product = new Product();
        product.setDescription("Spring Framework Demo Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getId()); //not null after save
        //fetch from DB
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);

        //should not be null
        assertNotNull(fetchedProduct);

        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());

        //update description and save
        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Product fetchedUpdatedProduct = productRepository.findById(fetchedProduct.getId()).orElse(null);
        assertNotNull(fetchedUpdatedProduct);
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

        //verify count of products in DB
        long productCount = productRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Product> products = productRepository.findAll();

        int count = 0;

        for(Product tempProd : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
