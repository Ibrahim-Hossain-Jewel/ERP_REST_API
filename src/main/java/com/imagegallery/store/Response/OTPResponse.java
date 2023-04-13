package com.imagegallery.store.Response;

public class OTPResponse {
    Boolean status;
    String message;

    public OTPResponse(String message, Boolean status) {
        this.status = status;
        this.message = message;
    }

    public OTPResponse() {
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "OTPResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
