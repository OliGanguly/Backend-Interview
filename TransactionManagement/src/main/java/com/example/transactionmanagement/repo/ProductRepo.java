package com.example.transactionmanagement.repo;

import com.example.transactionmanagement.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
