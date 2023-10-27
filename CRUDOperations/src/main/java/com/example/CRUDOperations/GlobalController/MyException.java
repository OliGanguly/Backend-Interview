package com.example.CRUDOperations.GlobalController;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.CRUDOperations.customeException.EmptyInputException;

/*
 * ControllerAdvice - handle exception globally
 * use multiple method over here to handle exception
 * */
//@ControllerAdvice
public class MyException extends ResponseEntityExceptionHandler {
//	//if controller is not able to handle exception please send a good message
//
//	@ExceptionHandler(EmptyInputException.class)
//	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
//		return new ResponseEntity<String>("Input Field is empty",HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
//		return new ResponseEntity<String>("No value is present in DB , Please change your request",HttpStatus.NOT_FOUND);
//	}
//	@Override
//	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		// TODO Auto-generated method stub
//		return new ResponseEntity<Object>("Method Not allowed, Please change your Http Method Type",HttpStatus.METHOD_FAILURE);
//	}
//
}
