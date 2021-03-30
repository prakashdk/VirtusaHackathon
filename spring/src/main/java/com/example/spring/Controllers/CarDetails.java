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
    private int carId;

    @Column(name="status")
    private String status;

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}