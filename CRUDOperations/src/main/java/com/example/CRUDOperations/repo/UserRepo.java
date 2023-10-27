package com.example.CRUDOperations.repo;

import com.example.CRUDOperations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findById(int id);
}
