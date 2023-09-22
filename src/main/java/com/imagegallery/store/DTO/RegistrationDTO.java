package com.imagegallery.store.DTO;

import org.springframework.stereotype.Repository;

//DTO help to hide implementation details of domain object.(JPA Entities)
@Repository
public class RegistrationDTO {
    private long userid;
    private String username;
    private String email;
    private String password;
    private String mobilenumber;
    private String address;
    private String profilepicture;

    public RegistrationDTO() {
    }
    public RegistrationDTO(String username, String email, String mobilenumber, String address){
        this.username = username;
        this.email = email;
        this.mobilenumber = mobilenumber;
        this.address = address;
    }
    public RegistrationDTO(long userid, String username, String email, String password, String mobilenumber, String address) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobilenumber = mobilenumber;
        this.address = address;
    }
    //constructor for update user profile data and set image
    public RegistrationDTO(long userid, String username, String email, String password, String mobilenumber, String address, String profilepicture) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobilenumber = mobilenumber;
        this.address = address;
        this.profilepicture = profilepicture;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
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

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
