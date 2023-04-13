package com.imagegallery.store.Model;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.swing.*;

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

    public User(Long userid, String username, String email, String password){
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public User() {
        System.out.println("From your registration entity");
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
        return "RegistrationEntiy{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}