package com.example.CRUDOperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUDOperations.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
