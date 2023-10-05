package com.example.sept23demo;

import io.pragra.learning.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.example.sept23demo","io.pragra.learning"})
public class Sept23DemoApplication {

	public static void main(String[] args) {

			SpringApplication.run(Sept23DemoApplication.class, args);
	}

}
