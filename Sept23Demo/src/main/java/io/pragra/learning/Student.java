package io.pragra.learning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component

public class Student {
    @Value("${name}")
    private String name;
    @Value("${phone}")
    private String phone;
    @PostConstruct
    public void printStudent(){
        System.out.println(name+ " : "+phone);
    }
}
