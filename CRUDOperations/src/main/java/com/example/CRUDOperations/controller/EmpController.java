package com.example.CRUDOperations.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDOperations.customeException.BusinessException;
import com.example.CRUDOperations.customeException.ControllerException;
import com.example.CRUDOperations.entity.Employee;
import com.example.CRUDOperations.service.EmpService;

@RestController
@RequestMapping("/emp")
//@Slf4j
public class EmpController {
	
	@Autowired
	private EmpService empService;

	 Logger logger = LoggerFactory.getLogger(EmpController.class);

	/*@PostMapping("/add")
	public ResponseEntity<?> createEmp(@RequestBody Employee employee) {
		try {
		Employee emp = empService.addEmp(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		}catch (BusinessException e) {
		ControllerException cException = new ControllerException(e.getErrorCode(),e.getDescription());
		return new ResponseEntity<ControllerException>(cException,HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
		ControllerException cException = new ControllerException("611","Something went wrong in Controller");
		return new ResponseEntity<ControllerException>(cException,HttpStatus.BAD_REQUEST);
		}
	}*/
	@PostMapping("/save")
	public ResponseEntity<?> createEmp(@RequestBody Employee employee) throws Exception{

		Employee emp = empService.addEmp(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);	
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> fetAllEmployees(){
		logger.info("Message Logging......");
		List<Employee> list = empService.getAll();
		List<String> allemps = empService.getAll().stream().map(emp->emp.getName()).collect(Collectors.toList());
        //create a Set
		Set<String> set = new HashSet<>();
		//only find those which are already present so set.add return false
		Set<String> collect = allemps.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id){
		Employee  empOptional =  empService.findOneById(id);
		return new ResponseEntity<Employee>(empOptional,HttpStatus.OK);
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmp(@PathVariable("id")int id){
		empService.deleteEmp(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp) throws Exception {
		Employee employee = empService.addEmp(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/")
	public String home(){
		return "<h1>Home</h1>";
	}
	@GetMapping("/user")
	public String User(){
		return "<h1>Hi User</h1>";
	}
	@GetMapping("/admin")
	public String Admin(){
		return "<h1>Hi Admin</h1>";
	}
	

}
