package com.example.transactionmanagement.service;

import com.example.transactionmanagement.Entity.Product;
import com.example.transactionmanagement.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Transactional //start
    public void saveProduct() throws Exception{
        System.out.println("Method started");
    for(int i=1;i<=10;i++){
        Product product=new Product();
        product.setId(i);
        product.setName("Test Product "+ i);
        productRepo.save(product);
//        if(i==7){
//            throw  new RuntimeException("Some Error");
//        }//rollback

    }//commit
        System.out.println("Method ended");
    }
}
