package com.example.transactionmanagement.util;

import com.example.transactionmanagement.exception.InsufficientBalance;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtil {
    private static Map<String,Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1",2000.0);
        paymentMap.put("acc2",13000.0);
        paymentMap.put("acc3",1500.0);
        paymentMap.put("acc4",15000.0);
        paymentMap.put("acc5",6000.0);
    }
     public static boolean validateCreditLimit(String accNo,Double paidAmt){
      if(paidAmt>paymentMap.get(accNo)){
       throw new InsufficientBalance("Balance LOW ...");
      }else{
          return true;
      }

    }
}
