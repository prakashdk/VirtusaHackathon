package com.example.spring.Controllers;

import javax.persistence.*;

@Entity
public class Admin {
    
    @Id
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "userrole")
    private String userrole;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private String age;

    @Column(name = "mobilenumber")
    private String mobileNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


}