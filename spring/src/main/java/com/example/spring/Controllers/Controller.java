package com.example.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    @Autowired
   private CustomerRepository customerRepository;

   @Autowired
   private CarRepository carRepository;

    @RequestMapping("/")
    public String home(){
        return "Welcome home";
    }

    //User Side

    @RequestMapping("user/login")
    public boolean userLogin(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password){
        try{
            Customer customer=customerRepository.findById(email).get();
            return customer.getPassword().equals(password);
        }catch(Exception e){
            return false;
        }
        
    }

    @RequestMapping("user/signup")
    public String userSignup(@RequestParam(name = "usermodel") Customer customer){
        try {
            customerRepository.save(customer);
            return "added";
        } catch (Exception e) {
            return "failed :"+e;
        }
        
    }

    @RequestMapping("user/sample-signup")
    public String userSignup(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password,@RequestParam(name = "userrole") String userRole,@RequestParam(name = "username") String username,@RequestParam(name = "age") String age,@RequestParam(name = "mobilenumber") String mobileNumber){
        try {
            Customer customer=new Customer();
            customer.setEmail(email);
            customer.setPassword(password);
            customer.setUserrole(userRole);
            customer.setUsername(username);
            customer.setAge(age);
            customer.setMobileNumber(mobileNumber);
            customerRepository.save(customer);
            return "added";
        } catch (Exception e) {
            return "failed :"+e;
        }
        
    }

    @RequestMapping("user/dashboard")
    public String userDashboard(){
        return "Companies";
    }

    @RequestMapping("user/cars")
    public ArrayList<Car> displayingHotelCars(@RequestParam(name = "adminid") String adminId){
        ArrayList<Car> aList=new ArrayList<Car>();
        try{
            
            for(Car c:carRepository.findAll()) if(c.getCarAdminId().equals(adminId)) aList.add(c);
        }catch(Exception e){
            
        }
        return aList;
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
            customerRepository.deleteById(email);
            return "removed";
        }catch(Exception e){
            return "failed";
        }
        
    }

    @RequestMapping("super/getuser")
    public Iterable<Customer> getUser(){
        try{
            
            return customerRepository.findAll();
        }catch(Exception e){
            return null;
        }
        
    }

    @RequestMapping("admin/addcar")
    public String setCar(@RequestParam(name="carmodel") String car){
        try{
            Car c=new Car();
            c.setId(1);
            c.setCarName("TATA");
            c.setCarModel("Nexon");
            c.setCarType("Diesel/Petrol . Manual/Automatic");
            c.setCarPrice("10000");
            c.setCarStatus("Available");
            c.setCarDescription("Car Descriptin");
            c.setCarAdminId("1");
            carRepository.save(c);
            return "saved";
        }catch(Exception e){
            return "failed";
        }
        
    }
}