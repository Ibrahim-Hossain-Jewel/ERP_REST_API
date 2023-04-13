package com.imagegallery.store.Response;

public class ForgotResponse {
    String message;
    Boolean status;

    public ForgotResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public ForgotResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
