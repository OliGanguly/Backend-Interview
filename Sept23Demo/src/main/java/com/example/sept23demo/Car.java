package com.example.sept23demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Car {
    @Value("${car.make:Honda}")
    private String make;

    @Value("${car.model:Civic}")
    private String model;

    @PostConstruct
    public void PrintMe(){
        System.out.println(make+" : "+model);
    }

}
