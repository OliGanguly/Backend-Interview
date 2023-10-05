package com.example.CRUDOperations.service;

import com.example.CRUDOperations.entity.Address;
import com.example.CRUDOperations.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Transactional
    public Address addAddress(Address address){
     return addressRepo.save(address);
    }
}
