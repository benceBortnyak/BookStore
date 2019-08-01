package com.codecool.web.model;

public class User extends AbstractModel {

    private final String email;
    private String password;
    private final String firstName;
    private final String secondName;
    private Boolean isAdmin;
    private Integer userCredit;

    public User(int id, String email, String password, String firstName, String secondName, Boolean isAdmin, Integer userCredit) {
        super(id);
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isAdmin = isAdmin;
        this.userCredit = userCredit;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }
}
