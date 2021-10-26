package com.example.bancovirtual.Account;

public abstract class BaseUser {
    private final String username, password, number;
    private final String userType;

    protected BaseUser(String username, String password, String number, String userType) {
        this.username = username;
        this.password = password;
        this.number = number;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String getUserType() {
        return userType;
    }

    public String getNumber() {
        return number;
    }
}
