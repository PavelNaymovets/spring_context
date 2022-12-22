package com.naumovets.context.infofromlesson;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component //передаю управление над созданием объекта IcO-контейнеру(Spring контейнер)
@Scope("prototype") //меня область видимости(паттерн создания объекта). По умолчанию singleton(разделенный объект), prototype(независимый объект)
public class Box {
    private String color;

    public Box() {
    }

    public Box(String color) {
        this.color = color;
    }

    //Инициализация параметра через @postconstruct. Произойдет вызов этого метода, после поздания объекта через конструктор
    //для преднастройки полей лучше применять эту аннотацию. Не сетить поля через конструктор. Не рекомендуют разработчики Spring
    @PostConstruct
    public void init() {
        this.color = "Green";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
