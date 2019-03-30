package com.example.coopacola.Interface.Model;

public interface IUserPass {
    String getId();
    String getUsername();
    String getPassword();
    String getLoginAttempt();

    int checkUserValidity(String id, String password);
}
