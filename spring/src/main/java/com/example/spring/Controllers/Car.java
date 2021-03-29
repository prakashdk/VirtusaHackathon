package com.example.spring.Controllers;

import javax.persistence.*;

@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="carname")
    private String carName;

    @Column(name="carmodel")
    private String carModel;

    @Column(name="cartype")
    private String carType;

    @Column(name="carprice")
    private String carPrice;

    @Column(name="cardescription")
    private String carDescription;

    @Column(name="carstatus")
    private String carStatus;

    @Column(name="caradmin")
    private String carAdminId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarAdminId() {
        return carAdminId;
    }

    public void setCarAdminId(String carAdminId) {
        this.carAdminId = carAdminId;
    }

}