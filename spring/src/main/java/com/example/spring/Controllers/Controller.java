package com.example.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/super")
public class Controller {

    @Autowired
   private CustomerRepository customerRepository;

   @Autowired
   private CarRepository carRepository;

   @Autowired
   private CarDetailsRepository carDetailsRepository;

    @RequestMapping("/")
    public String home(){
        return "Welcome home";
    }

    
    //Super Admin Side

    @RequestMapping("/login")
    public boolean superUserLogin(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password){
        try{
            
            return email.equals("superadmin@neocars.com")&&password.equals("superadmin@neocars");
        }catch(Exception e){
            return false;
        }
        
    }
    @RequestMapping("/deleteadmin")
    public String deleteAdmin(@RequestParam(name = "adminid") String adminId){
        try{
            
            return "removed";
        }catch(Exception e){
            return "failed";
        }
        
    }
    @RequestMapping("/deleteuser")
    public String deleteUser(@RequestParam(name = "emailid") String email){
        try{
            customerRepository.deleteById(email);
            return "removed";
        }catch(Exception e){
            return "failed";
        }
        
    }

    @RequestMapping("/getuser")
    public Iterable<Customer> getUser(){
        try{
            
            return customerRepository.findAll();
        }catch(Exception e){
            return null;
        }
        
    }

    
}