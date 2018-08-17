package com.cts.devops.demo.controllers;

import com.cts.devops.demo.domain.Product;
import com.cts.devops.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The type Product controller.
 */
@Controller
public class ProductController {

    /**
     * The Product service.
     */
    private ProductService productService;

    /**
     * Sets product service.
     *
     * @param productService the product service
     */
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * List string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        System.out.println("Returning rpoducts:");
        return "products";
    }

    /**
     * Show product string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    /**
     * Edit string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    /**
     * New product string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * Save product string.
     *
     * @param product the product
     * @return the string
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }
}
