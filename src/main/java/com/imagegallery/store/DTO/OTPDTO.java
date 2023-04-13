package com.imagegallery.store.DTO;

public class OTPDTO {
    private Integer otp;
    private String email;

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OTPDTO(Integer otp, String email) {
        this.otp = otp;
        this.email = email;
    }

    public OTPDTO() {
    }

    @Override
    public String toString() {
        return "OTPDTO{" +
                "otp=" + otp +
                ", email='" + email + '\'' +
                '}';
    }
}
