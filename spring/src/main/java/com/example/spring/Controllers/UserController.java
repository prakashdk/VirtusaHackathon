package com.example.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

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
        return "Welcome user";
    }

    //User Side

    @RequestMapping("/login")
    public boolean userLogin(@RequestParam(name = "emailid") String email,@RequestParam(name = "password") String password){
        try{
            Customer customer=customerRepository.findById(email).get();
            return customer.getPassword().equals(password);
        }catch(Exception e){
            return false;
        }
        
    }

    @RequestMapping("/signup")
    public String userSignup(@RequestParam(name = "usermodel") Customer customer){
        try {
            customerRepository.save(customer);
            return "added";
        } catch (Exception e) {
            return "failed :"+e;
        }
        
    }

    @RequestMapping("/sample-signup")
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

    @RequestMapping("/dashboard")
    public Iterable<Admin> getAdmin(){
        try{
            
            return adminRepository.findAll();
        }catch(Exception e){
            return new ArrayList<Admin>();
        }
        
    }

    @RequestMapping("/cars")
    public ArrayList<Car> displayingHotelCars(@RequestParam(name = "adminid") String adminId){
        ArrayList<Car> aList=new ArrayList<Car>();
        try{
            
            for(Car c:carRepository.findAll()) if(c.getCarAdminId().equals(adminId)) aList.add(c);
        }catch(Exception e){
            
        }
        return aList;
    }

    @RequestMapping("/cardetails")
    public Car carDetails(@RequestParam(name = "carid") int carId){
        try{
            
            return carRepository.findById(carId).get();
        }catch(Exception e){
            return new Car();
        }
        
    }

    
    @RequestMapping("/book")
    public String carDetails(@RequestParam(name = "carid") int carId,@RequestParam(name = "emailid") String emailId){
        try{
            
            Car car=carRepository.findById(carId).get();
            if(car.getCarStatus().toLowerCase().equals("available")){
                car.setCarStatus("Booked");
                carRepository.save(car);
                CarDetails carDetails=new CarDetails();
                carDetails.setCarId(carId);
                carDetails.setEmailid(emailId);
                carDetails.setStatus("0");
                carDetailsRepository.save(carDetails);
                return "Booked";
            }
            else{
                return "Unavailable";
            }
        }catch(Exception e){
            return "failed";
        }
        
    }
    
    @RequestMapping("/bookings")
    public Iterable<Car> bookedCars(@RequestParam(name = "emailid") String emailId){
        ArrayList<Car> aList=new ArrayList<Car>();
        try{
            ArrayList<Integer> carIds=new ArrayList<Integer>();
            Iterable<CarDetails> iterable=carDetailsRepository.findAll();
            for(CarDetails carDetails:iterable) if(carDetails.getEmailid().equals(emailId)) carIds.add(carDetails.getCarId()); 
            for(Integer id:carIds) aList.add(carRepository.findById(id).get()); 
            return aList;
        }catch(Exception e){
            return aList;
        }
    }

    
}