package com.example.spring.Controllers;

import org.springframework.data.repository.CrudRepository;

public interface CarDetailsRepository extends CrudRepository<CarDetails,String> {
    
}