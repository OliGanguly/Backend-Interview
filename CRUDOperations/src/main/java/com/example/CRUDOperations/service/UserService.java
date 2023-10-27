package com.example.CRUDOperations.service;

import com.example.CRUDOperations.customeException.UserNotFoundException;
import com.example.CRUDOperations.dto.UserRequest;
import com.example.CRUDOperations.entity.User;
import com.example.CRUDOperations.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User addUser(UserRequest userRequest){
       User user = User.build(
               0,
               userRequest.getName(),
               userRequest.getEmail(),
               userRequest.getMobile(),
               userRequest.getGender(),
               userRequest.getAge(),
               userRequest.getNationality());
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    public User getSingleUser(int id){
//       return userRepo.findById(id).orElseThrow(()->
//         new UserNotFoundException("This User Not Found with Id: "+id));
        User user = userRepo.findById(id);
        if(user!=null){
            return user;
        }else {
            throw new UserNotFoundException("This User Not Found with Id: "+id);
        }
    }
}
