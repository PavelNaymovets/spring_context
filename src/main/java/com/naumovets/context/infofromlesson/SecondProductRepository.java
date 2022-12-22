package com.naumovets.context.infofromlesson;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary //будет использоваться эта реализация интерфейса если на других реализациях не указана аннотация @qualifier
public class SecondProductRepository implements ProductRepository{
    @Override
    public Product findById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
