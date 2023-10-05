package com.example.profillinginspringboot.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//#my qa is active i want to get key from dev without exception
@PropertySource("application-dev.properties")
public class ProfileDemo {
    @Value("${message}")
    private String message;
    @Value("${devkey}")
    private String key;

    //after bean is created i want to print this
    @PostConstruct
    public void printMe(){
        System.out.println("Message : "+message);
        System.out.println("key : "+key);
    }

}
