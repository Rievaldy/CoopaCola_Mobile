package com.example.coopacola.Model;

import com.example.coopacola.Interface.Model.IUserPass;

public class UserPass implements IUserPass {
    private String id;
    private String username;
    private String password;
    private String loginAttempt;

    public UserPass(String id, String username, String password, String loginAttempt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loginAttempt = loginAttempt;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLoginAttempt() {
        return loginAttempt;
    }

    @Override
    public int checkUserValidity(String id, String password) {
        return 0;
    }
}
