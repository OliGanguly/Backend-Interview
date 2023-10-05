package com.example.transactionmanagement.dto;

import com.example.transactionmanagement.Entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String status;
    private double totalFare;
    private String invoiceNo;
    private Passenger passenger;
}
