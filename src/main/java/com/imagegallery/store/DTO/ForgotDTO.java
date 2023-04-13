package com.imagegallery.store.DTO;

public class ForgotDTO {
    //resetDTO
    private String email;

    public ForgotDTO(String email) {
        this.email = email;
    }

    public ForgotDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
