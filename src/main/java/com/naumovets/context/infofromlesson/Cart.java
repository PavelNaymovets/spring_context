package com.naumovets.context.infofromlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private ProductService productService;
    private List<String> productCart;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init() {
        productCart = new ArrayList<>();
    }

    public void addProduct(Long productId) {
        String productTitle = productService.getTitleById(productId);
        productCart.add(productTitle);
        getAllProducts();
    }

    public void deleteProduct(Long productId) {
        String productTitle = productService.getTitleById(productId);
        productCart.remove(productTitle);
        getAllProducts();
    }

    public void getAllProducts() {
        System.out.println(productCart);
    }
}
