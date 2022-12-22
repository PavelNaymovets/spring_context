package com.naumovets.context.homeWork;

import com.naumovets.context.infofromlesson.AppConfig;
import com.naumovets.context.infofromlesson.Cart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) {
        //Говорю спрингу где расположить контекст, т.е. по каким классам создавать объекты bean.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Пример с @scope("prototype"). По умолчанию @scope("singleton")
//        Box box_1 = context.getBean(Box.class);
//        System.out.println(box_1.getColor());
//        box_1 = context.getBean(Box.class);
//        box_1.setColor("Blue");
//        System.out.println(box_1.getColor());

        //Пример из урока
//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.createOrderFromProduct(1L);
//        orderService.getAllOrderedProducts();

        //Домашняя работа
        Cart cart_1 = context.getBean(Cart.class);
        Cart cart_2 = context.getBean(Cart.class);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String line = bf.readLine();
                if (line != null) {
                    String[] str = line.split(" ");
                    String cartName = str[0];

                    if (cartName.equals("cart_1")) {
                        driveCart(str, cart_1);
                    } else if (cartName.equals("cart_2")) {
                        driveCart(str, cart_2);
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Закрываю контекст
        context.close();
    }

    private static void driveCart(String[] str, Cart cart) {
        String action = str[1];
        Long productId = Long.parseLong(str[2]);
        switch (action) {
            case "cart_add" -> cart.addProduct(productId);
            case "cart_delete" -> cart.deleteProduct(productId);
            default -> System.out.println("Консоль понимает: cart_add, cart_delete, cart_all");
        }
    }
}
