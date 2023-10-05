package com.example.transactionmanagement.dto;

import com.example.transactionmanagement.Entity.Passenger;
import com.example.transactionmanagement.Entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private Passenger passenger;
    private Payment payment;
}
