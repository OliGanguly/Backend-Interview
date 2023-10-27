package com.example.CRUDOperations.controller;

import com.example.CRUDOperations.customeException.UserNotFoundException;
import com.example.CRUDOperations.dto.UserRequest;
import com.example.CRUDOperations.entity.User;
import com.example.CRUDOperations.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody @Valid UserRequest userRequest){
        User user = userService.addUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getall(){
        return  ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable int id)  {
        User singleUser = userService.getSingleUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(singleUser);
    }




}
