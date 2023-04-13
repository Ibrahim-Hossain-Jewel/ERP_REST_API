package com.imagegallery.store.DTO;

public class NewPasswordDTO {
    String email;
    String password;

    public NewPasswordDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public NewPasswordDTO() {
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
        return "NewPasswordDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
