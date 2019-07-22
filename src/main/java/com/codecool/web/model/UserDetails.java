package com.codecool.web.model;

public class UserDetails extends User {
    private final int detail_id;
    private final String user_city;
    private final String user_street;
    private final int user_zipcode;
    private final int user_street_number;
    private final int purchase_count;
    private final int feedback;
    private final int detail_user_id;
    private final int user_id;

    public UserDetails(int id, String email, String password, String username, String firstName, String secondName, Boolean isAdmin, Integer user_credit, int detail_id, String user_city, String user_street, int user_zipcode, int user_street_number, int purchase_count, int feedback, int detail_user_id, int user_id) {
        super(id, email, password, username, firstName, secondName, isAdmin, user_credit);
        this.detail_id = detail_id;
        this.user_city = user_city;
        this.user_street = user_street;
        this.user_zipcode = user_zipcode;
        this.user_street_number = user_street_number;
        this.purchase_count = purchase_count;
        this.feedback = feedback;
        this.detail_user_id = detail_user_id;
        this.user_id = user_id;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public String getUser_city() {
        return user_city;
    }

    public String getUser_street() {
        return user_street;
    }

    public int getUser_zipcode() {
        return user_zipcode;
    }

    public int getUser_street_number() {
        return user_street_number;
    }

    public int getPurchase_count() {
        return purchase_count;
    }

    public int getFeedback() {
        return feedback;
    }

    public int getDetail_user_id() {
        return detail_user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
