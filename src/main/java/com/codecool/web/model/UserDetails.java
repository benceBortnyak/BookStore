package com.codecool.web.model;

public class UserDetails extends User {
    private final int detailId;
    private final String userCity;
    private final String userStreet;
    private final int userZipcode;
    private final int userStreetNumber;
    private final int detailUserId;
    private final int userId;

    public UserDetails(int id, String email, String password, String firstName, String secondName, Boolean isAdmin, Integer userCredit, int detailId, String userCity, String userStreet, int userZipcode, int userStreetNumber, int detailUserId, int userId) {
        super(id, email, password, firstName, secondName, isAdmin, userCredit);
        this.detailId = detailId;
        this.userCity = userCity;
        this.userStreet = userStreet;
        this.userZipcode = userZipcode;
        this.userStreetNumber = userStreetNumber;
        this.detailUserId = detailUserId;
        this.userId = userId;
    }

    public int getDetailId() {
        return detailId;
    }

    public String getUserCity() {
        return userCity;
    }

    public String getUserStreet() {
        return userStreet;
    }

    public int getUserZipcode() {
        return userZipcode;
    }

    public int getUserStreetNumber() {
        return userStreetNumber;
    }

    public int getDetailUserId() {
        return detailUserId;
    }

    public int getUserId() {
        return userId;
    }
}
