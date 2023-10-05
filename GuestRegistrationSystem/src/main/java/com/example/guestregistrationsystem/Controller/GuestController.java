package com.example.guestregistrationsystem.Controller;

import com.example.guestregistrationsystem.Entity.Guest;
import com.example.guestregistrationsystem.Repository.GuestRepo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class GuestController {
    private GuestRepo repo;

    public GuestController(GuestRepo repo) {
        this.repo = repo;
    }
    @PostMapping("/api/add")
    public Guest createRest(@RequestBody Guest guest){
        guest.setCreateDate(new Date());
        guest.setUpdateDate(new Date());
        return repo.save(guest);
    }

    @GetMapping("/api/all")
    public List<Guest> getall(){
        return repo.findAll();
    }
    @GetMapping("/api/{id}")
    public Optional<Guest> getall(@PathVariable int id){
        return repo.findById(id);
    }
}
