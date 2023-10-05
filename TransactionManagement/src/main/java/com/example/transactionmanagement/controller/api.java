package com.example.transactionmanagement.controller;

import com.example.transactionmanagement.dto.BookingResponse;
import com.example.transactionmanagement.dto.FlightBookingRequest;
import com.example.transactionmanagement.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class api {
    @Autowired
    private FlightBookingService flightBookingService;
    @PostMapping("/book")
    public BookingResponse bookFlightTicket(@RequestBody FlightBookingRequest request){
        BookingResponse bookingResponse = flightBookingService.bookTicket(request);
        return  bookingResponse;
    }

}
