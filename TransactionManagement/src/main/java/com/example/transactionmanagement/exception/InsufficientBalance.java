package com.example.transactionmanagement.exception;

public class InsufficientBalance extends RuntimeException{

    public InsufficientBalance(String msg) {
        super(msg);
    }
}
