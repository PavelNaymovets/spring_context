package com.naumovets.context.infofromlesson;

import java.util.List;

public interface ProductRepository { //ослабление связи между бинами. Чтобы один бин не привязывать жестко к другому бину.
    Product findById(Long id);
    List<Product> getAllProducts();
}
