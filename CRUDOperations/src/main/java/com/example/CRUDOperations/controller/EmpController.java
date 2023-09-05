package com.example.CRUDOperations.controller;

import java.util.List;
import java.util.Optional;

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
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	/*(@PostMapping("/add")
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
	@PostMapping("/add")
	public ResponseEntity<?> createEmp(@RequestBody Employee employee) {
		Employee emp = empService.addEmp(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> fetAllEmployees(){
		List<Employee> allemps = empService.getAll();
		return new ResponseEntity<List<Employee>>(allemps,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getById(@PathVariable int id){
		Optional<Employee>  empOptional =  empService.findOneById(id);
		return new ResponseEntity<Optional<Employee>>(empOptional,HttpStatus.OK);
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmp(@PathVariable("id")int id){
		empService.deleteEmp(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp) {
		Employee employee = empService.addEmp(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
		
	}
	

}
