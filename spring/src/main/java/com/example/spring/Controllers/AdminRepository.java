package com.example.spring.Controllers;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,String> {
    
}