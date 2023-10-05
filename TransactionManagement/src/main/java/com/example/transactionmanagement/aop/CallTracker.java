package com.example.transactionmanagement.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //what is non functioanl code
@Component
public class CallTracker {

    //before which method you want to execute - Pointcut
    @Pointcut("com..service.*")//all classess inside the package
    public void LogMethodPointcut(){
        //say before every repo class
    }

    @Before("LogMethodPointcut") //when u need the code to run before/after/beforeAndAfter
      public void logBeforeMethodCall(){
        System.out.println("Execute before method call/Starting...........");
}
}
