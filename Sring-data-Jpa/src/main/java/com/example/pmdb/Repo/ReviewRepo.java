package com.example.pmdb.Repo;

import com.example.pmdb.Entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Reviews,Long> {

}
