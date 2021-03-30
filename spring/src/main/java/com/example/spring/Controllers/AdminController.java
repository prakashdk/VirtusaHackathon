package com.example.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
   private CustomerRepository customerRepository;

   @Autowired
   private CarRepository carRepository;

   @Autowired
   private CarDetailsRepository carDetailsRepository;

   @Autowired
   private AdminRepository adminRepository;

    @RequestMapping("/")
    public String home(){
        return "Welcome admin";
    }

    //Admin Side

    @RequestMapping("/login")
    public boolean adminLogin(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password){
        try{
            Admin admin=adminRepository.findById(email).get();
            return admin.getPassword().equals(password);
        }catch(Exception e){
            return false;
        }
        
    }

    @RequestMapping("/signup")
    public String adminSignup(@RequestParam(name = "usermodel") Admin admin){
        try {
            adminRepository.save(admin);
            return "added";
        } catch (Exception e) {
            return "failed :"+e;
        }
        
    }

    @RequestMapping("/sample-signup")
    public String adminSignup(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password,@RequestParam(name = "userrole") String userRole,@RequestParam(name = "username") String username,@RequestParam(name = "age") String age,@RequestParam(name = "mobilenumber") String mobileNumber){
        try {
            Admin admin=new Admin();
            admin.setEmail(email);
            admin.setPassword(password);
            admin.setUserrole(userRole);
            admin.setUsername(username);
            admin.setAge(age);
            admin.setMobileNumber(mobileNumber);
            adminRepository.save(admin);
            return "added";
        } catch (Exception e) {
            return "failed :"+e;
        }
        
    }

    @RequestMapping("/dashboard")
    public ArrayList<Car> adminDashboard(@RequestParam(name="adminid") String adminId){
        ArrayList<Car> aList=new ArrayList<Car>();
        try{
            
            for(Car c:carRepository.findAll()) if(c.getCarAdminId().equals(adminId)) aList.add(c);
        }catch(Exception e){
            
        }
        return aList;
    }

    @RequestMapping("/sample-addcar")
    public String setCar(){
        try{
            Car c=new Car();
            c.setId(1);
            c.setCarName("TATA");
            c.setCarModel("Nexon");
            c.setCarType("Diesel/Petrol . Manual/Automatic");
            c.setCarPrice("10000");
            c.setCarStatus("Available");
            c.setCarDescription("Car Descriptin");
            c.setCarAdminId("smith@gmailcom");
            carRepository.save(c);
            return "saved";
        }catch(Exception e){
            return "failed";
        }
        
    }

    @RequestMapping(value = {"/addCar","/editCar"})
    public String setCar(@RequestParam(name="carmodel") Car car){
        try{
            carRepository.save(car);
            return "saved";
        }catch(Exception e){
            return "failed";
        }
        
    }

    @RequestMapping("/deleteCar")
    public String carDetails(@RequestParam(name = "carid") int carId){
        try{
            carRepository.deleteById(carId);
            return "removed";
        }catch(Exception e){
            return "failed";
        }
        
    }

    @RequestMapping(value={"/profile","/editProfile"})
    public Admin carDetails(@RequestParam(name = "adminid") String adminId){
        try{
            return adminRepository.findById(adminId).get();
        }catch(Exception e){
            return new Admin();
        }
        
    }

    @RequestMapping("/editProfile")
    public String carDetails(@RequestParam(name = "adminmodel") Admin admin){
        try{
            adminRepository.save(admin);
            return "saved";
        }catch(Exception e){
            return "failed";
        }
        
    }

   
}