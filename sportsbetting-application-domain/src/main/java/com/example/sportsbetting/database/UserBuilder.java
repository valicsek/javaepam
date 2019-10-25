package com.example.sportsbetting.database;

public class UserBuilder extends PlayerBuilder {

    private String email;
    private String password;

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }
}
