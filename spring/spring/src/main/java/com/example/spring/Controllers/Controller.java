package com.example.spring.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {
    @RequestMapping("/")
    public String home(){
        return "Welcome home";
    }

    //User Side

    @RequestMapping("user/login")
    public boolean userLogin(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password){
        try{
            Customer customer=new Customer();
            customer.setPassword(password);
            return customer.getPassword().equals(password);
        }catch(Exception e){
            return false;
        }
        
    }

    @RequestMapping("user/signup")
    public String userSignup(@RequestParam(name = "usermodel") Customer customer){
        try {
            return "added";
        } catch (Exception e) {
            return "failed";
        }
        
    }

    @RequestMapping("user/dashboard")
    public String userDashboard(){
        return "Companies";
    }

    @RequestMapping("user/cars")
    public Iterable<Customer> displayingHotelCars(@RequestParam(name = "companyname") String companyName,@RequestParam(name = "adminid") String adminId){
        try{
            
            return new ArrayList<Customer>();
        }catch(Exception e){
            return null;
        }
    }

    @RequestMapping("user/cardetails")
    public Iterable<Customer> carDetails(@RequestParam(name = "carid") String carId){
        try{
            
            return new ArrayList<Customer>();
        }catch(Exception e){
            return null;
        }
    }
    
    @RequestMapping("user/bookings")
    public Iterable<Customer> bookedCars(@RequestParam(name = "userid") String userId){
        try{
            
            return new ArrayList<Customer>();
        }catch(Exception e){
            return null;
        }
    }

    //Super Admin Side

    @RequestMapping("super/login")
    public boolean superUserLogin(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password){
        try{
            
            return email.equals("superadmin@neocars.com")&&password.equals("superadmin@neocars");
        }catch(Exception e){
            return false;
        }
        
    }
    @RequestMapping("super/deleteadmin")
    public String deleteAdmin(@RequestParam(name = "adminid") String adminId){
        try{
            
            return "removed";
        }catch(Exception e){
            return "failed";
        }
        
    }
    @RequestMapping("super/deleteuser")
    public String deleteUser(@RequestParam(name = "emailid") String email){
        try{
            
            return "removed";
        }catch(Exception e){
            return "failed";
        }
        
    }
    @RequestMapping("super/getuser")
    public Iterable<Customer> getUser(){
        try{
            
            return new ArrayList<Customer>();
        }catch(Exception e){
            return null;
        }
        
    }
}