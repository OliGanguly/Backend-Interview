package com.example.transactionmanagement.repo;

import com.example.transactionmanagement.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepo extends JpaRepository<Payment,String> {
}
