package com.example.spring.Controllers;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="emailid")
    private String emailid;

    @Column(name="car")
    private String carId;

    @Column(name="status")
    private String status;

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}