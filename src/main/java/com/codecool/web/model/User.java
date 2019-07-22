package com.codecool.web.model;

import java.util.Objects;

public class User extends AbstractModel {

    private final String email;
    private final String password;
    private final String username;
    private final String firstName;
    private final String secondName;
    private final Boolean isAdmin;
    private final Integer user_credit;

    public User(int id, String email, String password, String username, String firstName, String secondName, Boolean isAdmin, Integer user_credit) {
        super(id);
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isAdmin = isAdmin;
        this.user_credit = user_credit;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public Integer getUser_credit() {
        return user_credit;
    }
}
