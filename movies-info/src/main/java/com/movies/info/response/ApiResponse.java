package com.movies.info.response;

public class ApiResponse {

    private boolean succes;
    private String message;

    public ApiResponse(boolean succes, String message) {
        this.succes = succes;
        this.message = message;
    }

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
