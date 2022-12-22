package com.naumovets.context.infofromlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    @Qualifier("impr") //указываю какую именно реализацию нужно инжектить в поле. Сейчас 2 реализации.
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(Long id) {
        return productRepository.findById(id).getTitle();
    }

    public List<String> getTitleAllProducts() {
        List<Product> productList = productRepository.getAllProducts();
        List<String> productsTitle = new ArrayList<>();

        for (Product product : productList) {
            productsTitle.add(product.getTitle());
        }

        return productsTitle;
    }

}
