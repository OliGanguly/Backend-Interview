package com.example.CRUDOperations.advice;


import com.example.CRUDOperations.customeException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler  {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleInvalidException(MethodArgumentNotValidException methodArgumentNotValidException){
    Map<String,String> errorMsg = new HashMap<>();
//     extract exception msg and map it
            methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error->
           errorMsg.put(error.getField(),error.getDefaultMessage()));
    return  errorMsg;
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleUserNotFound(UserNotFoundException ex){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("ErrorMsg",ex.getMessage());
        return errorMap;
    }


}
