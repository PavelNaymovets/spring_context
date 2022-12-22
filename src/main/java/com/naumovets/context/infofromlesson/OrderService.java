package com.naumovets.context.infofromlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Component
public class OrderService {
//    @Autowired //dependency injection инъекция зависимости (добавление зависимости). Поля не сетить таким способом. Лучше это делать через сеттер
    private ProductService productService;
    private FileOutputStream fileOut;

    @Autowired //setter наиболее предпочтительный способ инъекции зависимости(добавление связи).
    public void setProductService(ProductService productService, FileOutputStream fileOut) {
        this.productService = productService;
        this.fileOut = fileOut;
    }

    public void createOrderFromProduct(Long productId) {
        System.out.println("Заказ создан: ");
        System.out.println(productService.getTitleById(productId));
        try {
            fileOut.write("READY".getBytes());
            fileOut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllOrderedProducts() {
        System.out.println("Ваши заказы: ");
        System.out.println(productService.getTitleAllProducts());
    }
}
