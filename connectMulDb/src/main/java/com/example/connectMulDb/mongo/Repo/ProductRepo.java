package com.example.connectMulDb.mongo.Repo;

import com.example.connectMulDb.mongo.Entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product,Integer> {

}
