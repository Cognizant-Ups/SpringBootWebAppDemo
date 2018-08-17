package com.cts.devops.demo.bootstrap;

import com.cts.devops.demo.domain.Product;
import com.cts.devops.demo.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * The type Product loader.
 */
@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * The Product repository.
     */
    private ProductRepository productRepository;

    /**
     * The Log.
     */
    private static final Logger log = LogManager.getLogger(ProductLoader.class);

    /**
     * Sets product repository.
     *
     * @param productRepository the product repository
     */
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Demo Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://www.cognizant-demo.com/wp-content/uploads/2015/04/spring_framework_demo_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Demo Mug");
        mug.setImageUrl("https://www.cognizant-demo.com/wp-content/uploads/2015/04/spring_framework_demo_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
