package com.example.demo.Auth;

public class TokenModel {
    private String userID;
    private String Authorization;

    public TokenModel() {
    }

    public TokenModel(String userID, String authorization) {
        this.userID = userID;
        Authorization = authorization;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }
}
