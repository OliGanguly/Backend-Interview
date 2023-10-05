package com.example.transactionmanagement.repo;

import com.example.transactionmanagement.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepo extends JpaRepository<Passenger,Long> {

}
