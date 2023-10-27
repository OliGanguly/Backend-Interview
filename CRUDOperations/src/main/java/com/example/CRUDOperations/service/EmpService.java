package com.example.CRUDOperations.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//import org.apache.naming.java.javaURLContextFactory;
import com.example.CRUDOperations.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUDOperations.customeException.BusinessException;
import com.example.CRUDOperations.customeException.EmptyInputException;
import com.example.CRUDOperations.entity.Employee;
import com.example.CRUDOperations.repo.EmpRepo;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpService {
    @Autowired
	private EmpRepo empRepo;
	@Autowired
	private AddressService addressService;
    
//	public Employee addEmp(Employee employee) {
//		//do put validation in try block
//		if(employee.getName().isEmpty()||employee.getName().length()==0) {
//			throw new BusinessException("601","Please send proper name");
//		}
//		try {
//			Employee savedResult = empRepo.save(employee);
//			return savedResult;
//		}catch (IllegalArgumentException e) {
//			// TODO: save indicate if whole entity is null - IllegalArgumentException
//			throw new BusinessException("602","Please Provide some data"+e.getMessage());
//		}catch (Exception e) {
//			throw new BusinessException("603","Something went wrong in Sevice Layer "+ " " + e.getMessage());
//		}
//
//	}

    //Global Exception
//	@Transactional
    public Employee addEmp(Employee employee) throws Exception{
		//do put validation in try block
		if(employee.getName().isEmpty()||employee.getName().length()<5) {
			throw new EmptyInputException("601","Inputs are Empty");
		}
  //After throwing Advice
//		if(employee.getName().length()<5){
//			throw new RuntimeException("Name should be more than 5 leength");
//		}
		return empRepo.save(employee);

//			Employee savedResult = empRepo.save(employee);
//			if(savedResult.getName().contains("code")){
//				throw  new RuntimeException("Error Occured");
//			}
//		Address address = new Address();
//			address.setId(1l);
//			address.setName("Canada");
//			address.setEmployee(employee);
//			addressService.addAddress(address);//Tranasctianal
//		return savedResult;
	
	}
	
	public List<Employee> getAll(){
		List<Employee> list=null;
		try {
        list= empRepo.findAll();
		}catch (Exception e) {
			throw new BusinessException("605","while fetching employee something went wrong"+e.getMessage());
		}if (list.isEmpty()) {
		throw new BusinessException("604","List is Empty");	
		}
		return list;
		
		
	}
	
//	public Optional<Employee> findOneById(int id) {
//		try {
//			Optional<Employee> employee = empRepo.findById(id);
//			return employee;
//		}catch (IllegalArgumentException e) {
//			//if findByid is null
//			throw new BusinessException("606","Given emp id is null , send some data");
//		}catch (java.util.NoSuchElementException e) {
//			// TODO: if id is null
//			throw new BusinessException("607","Given emp id not exist in database");
//		}
//		
//	}
	public Employee findOneById(int id) {
			Employee employee = empRepo.findById(id).orElseThrow(()->new NoSuchElementException());
			return employee;

	}
	public void deleteEmp(int id) {
		try {
			empRepo.deleteById(id);
		}catch (IllegalArgumentException e) {
			//if findByid is null
			throw new BusinessException("606","Given emp id is null , send some data");
		}catch (java.util.NoSuchElementException e) {
			// TODO: if id is null
			throw new BusinessException("607","Given emp id not exist in database");
		}
	}
//	public void updateEmp(Employee employee,int id) {
//	Optional<Employee> employee2 = empRepo.findById(id);
//
//	}
	
}
