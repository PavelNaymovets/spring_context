package com.naumovets.context.infofromlesson;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(value = "impr")
public class InMemoryProductRepository implements ProductRepository{
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1L,"Bread"),
                new Product(2L,"Milk"),
                new Product(3L,"Apples"),
                new Product(4L,"Tea"),
                new Product(5L,"Sugar")
        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(UnsupportedOperationException::new);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
