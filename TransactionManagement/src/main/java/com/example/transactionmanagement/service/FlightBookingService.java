package com.example.transactionmanagement.service;

import com.example.transactionmanagement.Entity.Passenger;
import com.example.transactionmanagement.Entity.Payment;
import com.example.transactionmanagement.dto.BookingResponse;
import com.example.transactionmanagement.dto.FlightBookingRequest;
import com.example.transactionmanagement.repo.PassengerInfoRepo;
import com.example.transactionmanagement.repo.PaymentInfoRepo;
import com.example.transactionmanagement.util.PaymentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepo passengerInfoRepo;
    @Autowired
    private PaymentInfoRepo paymentInfoRepo;
    @Transactional
    public BookingResponse bookTicket(FlightBookingRequest flightBookingRequest){
        //we need to store passenger+payment in db we need both two repos
        FlightBookingRequest acknowledgement=null;
        //get passenger and save
        Passenger passenger = flightBookingRequest.getPassenger();
        Passenger savedpassenger = passengerInfoRepo.save(passenger);
        //get payement and save
        Payment payment = flightBookingRequest.getPayment();
        //validate payment successfull or not
        PaymentUtil.validateCreditLimit(payment.getAccountNo(),payment.getAmount());//get exception if amount less
        //set data
        payment.setPassenderId(passenger.getPid());
        payment.setAmount(passenger.getFare());
        //save payment
        Payment savedPayment = paymentInfoRepo.save(payment);

        return new BookingResponse("Success",
                passenger.getFare(),
                UUID.randomUUID().toString().split("-")[0],
                passenger);
    }
}
