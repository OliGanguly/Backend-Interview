package com.example.CRUDOperations.aop;
import com.example.CRUDOperations.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.slf4j.SLF4JLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
@Slf4j
public class Logging {




//    @Before(value = "execution(* com.example.CRUDOperations.controller.EmpController.*(..))")
//    public void begorelogging(JoinPoint joinPoint){
//        System.out.println("LOGGING... : " + joinPoint.getSignature()  + new Date());
//    }
//
//    //just after method ended , method throw exception or not
//    @After(value = "execution(* com.example.CRUDOperations.controller.EmpController.*(..))")
//    public void afterlogging(JoinPoint joinPoint){
//        System.out.println("After LOGGING... : " + joinPoint.getSignature()  + new Date());
//    }
//
//
//    //Run After return successfully
//    @AfterReturning(value = "execution(* com.example.CRUDOperations.service.EmpService.addEmp(..))",returning = "employee")
//    public void afterReturninglogging(JoinPoint joinPoint,Employee employee){
//        System.out.println("After Returning LOGGING... : " + joinPoint.getSignature() + employee.getEmp_id() );
//    }
//    //
////    @AfterThrowing(value = "execution(* com.example.CRUDOperations.controller.EmpService.addEmp(..))",throwing = "exception")
////    public void afterThrowinglogging(JoinPoint joinPoint,Exception exception){
////        System.out.println("After Throwing LOGGING... : "
////                + joinPoint.getSignature()  + new Date()
////                + exception.getMessage()
////        );
////    }
//
////    @Around(value = "execution(* com.example.CRUDOperations.service.EmpService.addEmp(..))")
////    public Employee aroundAdvice(ProceedingJoinPoint joinPoint){
////        System.out.println("Inside Around Advice : "+ new Date());
////        try {
////            //can call multiple time
//////          joinPoint.proceed();
//////            joinPoint.proceed();
//////            joinPoint.proceed();
////            //cust bcz it returns Object
//////            Employee employee = (Employee) joinPoint.proceed();
//////            return employee;
////
////            Employee[] empArr = new Employee[1];
////            Employee dummyEmp = new Employee();
////            dummyEmp.setName("dummy");
////            empArr[0]=dummyEmp;
////            Employee employee=(Employee) joinPoint.proceed(empArr);
////            return employee;
////
////        }catch (Throwable e){
////            System.out.println("...Inside Around Advice :..." + new Date()+e.getMessage());
////            throw new RuntimeException(e);
////        }
////    }
//
////    Implement Loggong for any method presend in my web application
//
//    @Around("execution(* com.example.CRUDOperations..*.*(..))")
//    public Object globalLogging(ProceedingJoinPoint joinPoint) {
//        //start method Execution
//        log.info("//////////////////////////////////////////////////////////////////////////////////////////////////////");
//    log.info(joinPoint.getSignature().toString()+"Method execution Start");
//        Instant start = Instant.now();
//        try {
//            Object proceed = joinPoint.proceed();
//            Instant finish = Instant.now();
//            long millis = Duration.between(start, finish).toMillis();
//            log.info("Time Took to execute "+joinPoint.getSignature().toString()+"method is : "+millis);
//            log.info("Method execution end");
//            return proceed;
//        }catch (Throwable e){
//            log.info(e.getMessage() + "occured");
//            throw new RuntimeException("Error Occured");
//        }
//    }

//    @AfterThrowing(value = "execution(* *.*(..))",throwing = "e")
//    public void logException(JoinPoint joinPoint , Exception e){
//
//        log.error(joinPoint.getSignature() + "Error........"+ e.getMessage());
//    }

//    @AfterThrowing(pointcut = "execution (* * com..*(..)", throwing = "e")
//    public void myAfterThrowing(JoinPoint joinPoint, Exception e) {
//        System.out.println("IDS HABBENING");
//    }
}
