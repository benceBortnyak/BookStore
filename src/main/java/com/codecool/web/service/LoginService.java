package com.codecool.web.service;

public class LoginService {

    public boolean loginCheck(String email,String password,String actualPassword){
        if(password.equals(actualPassword)){
            return true;
        }
        return false;
    }
}
