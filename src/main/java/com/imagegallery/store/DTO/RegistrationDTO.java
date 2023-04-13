package com.imagegallery.store.DTO;

import org.springframework.stereotype.Repository;

//DTO help to hide implementation details of domain object.(JPA Entities)
@Repository
public class RegistrationDTO {
    private long userid;
    private String username;
    private String email;
    private String password;

    public RegistrationDTO(long userid, String username, String email, String password) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public RegistrationDTO() {
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
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
}
