package com.example.transactionmanagement;

import com.example.transactionmanagement.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionManagementApplication {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext run = SpringApplication.run(TransactionManagementApplication.class, args);
        ProductService productService =   run.getBean(ProductService.class);
        productService.saveProduct();

    }

}
