package com.imagegallery.store.Model;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.swing.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Repository
//model is the domain object name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userid;
    @Column(name = "username", length = 30)
    private String username;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "password", length = 3000)
    private String password;
    @Column(name = "mobilenumber", length = 30)
    private String mobilenumber;
    @Column(name = "address", length = 30)
    private String address;
    @Lob
    private String image;
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User( String username, String email, String password, String mobilenumber, String address){
        this.username  = username;
        this.email = email;
        this.password = password;
        this.mobilenumber = mobilenumber;
        this.address = address;
    }
    public User(Long userid, String username, String email, String password, String mobilenumber, String address){
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobilenumber = mobilenumber;
        this.address = address;
    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public User() {
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}