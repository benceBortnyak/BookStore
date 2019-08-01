package com.codecool.web.model;

public class UserDetails {
    private final int detailId;
    private final String userCity;
    private final String userStreet;
    private final int userZipcode;
    private final int userStreetNumber;
    private final int userId;

    public UserDetails(int detailId, String userCity, String userStreet, int userZipcode, int userStreetNumber,int userId) {
        this.detailId = detailId;
        this.userCity = userCity;
        this.userStreet = userStreet;
        this.userZipcode = userZipcode;
        this.userStreetNumber = userStreetNumber;
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

    public int getUserId() {
        return userId;
    }
}
