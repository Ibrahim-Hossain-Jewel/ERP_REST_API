package com.imagegallery.store.Response;

public class FileResponse {
    String message;
    Boolean status;

    public FileResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public FileResponse() {
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

    @Override
    public String toString() {
        return "ImageUpload{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
