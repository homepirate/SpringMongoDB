package com.spring.mongo.demo.repository;

import com.spring.mongo.demo.model.Home;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public interface HomeRepository extends MongoRepository<Home, String> {

    List<Home> findAll();

    Home findByIndex(int index);

    List<Home> findByType(String type);

    int countByCity(String city);

    @Override
    Optional<Home> findById(String s);
}
