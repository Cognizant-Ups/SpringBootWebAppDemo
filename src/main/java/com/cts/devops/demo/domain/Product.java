package com.cts.devops.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Product.
 */
@Entity
public class Product {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * The Version.
     */
    @Version
    private Integer version;

    /**
     * The Product id.
     */
    private String productId;

    /**
     * The Description.
     */
    private String description;

    /**
     * The Image url.
     */
    private String imageUrl;

    /**
     * The Price.
     */
    private BigDecimal price;

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets version.
     *
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets version.
     *
     * @param version the version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets product id.
     *
     * @param productId the product id
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets image url.
     *
     * @param imageUrl the image url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
