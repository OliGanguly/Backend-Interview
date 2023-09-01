package com.example.connectMulDb.mysql.Repo;

import com.example.connectMulDb.mysql.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
