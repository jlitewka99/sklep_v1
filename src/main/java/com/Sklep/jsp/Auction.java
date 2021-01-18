package com.Sklep.jsp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Auction {
    private String auctionID;
    private String title;
    private String description;
    private double price;
    public static final List<String> categoryList = new ArrayList<>(Arrays.asList("elektronika", "moda", "dom", "dziecko", "zdrowie", "sport", "motoryzacja"));
    private String category;
    private Date startDate;
    private Date endDate;
    private int numberOfPhotos;
    private String userId;
    private User user;

    public Auction(String auctionID, String title, String description, double price) {
        this.auctionID = auctionID;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Auction(String auctionID, String title, String description, double price, Date startDate, Date endDate, int numberOfPhotos, String userId) {
        this.auctionID = auctionID;
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPhotos = numberOfPhotos;
        this.userId = userId;
    }

    public Auction(String auctionID, String title, String description, double price, String category) {
        this.auctionID = auctionID;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    public int auctionValidate(String title, String description, int pictureCount, String category, Date endDate){
        if(title.length()<3){
            return 1;
        }
        return 0;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public String getUserId() {
        return userId;
    }

    /*
    public Auction(UserData start, UserData end, String description, String auctionID, String name, double price, User seller) {
        this.start = start;
        this.end = end;
        this.description = description;
        this.auctionID = auctionID;
        this.name = name;
        this.price = price;
        this.seller = seller;
    }

    public UserData getStart() {
        return start;
    }

    public void setStart(UserData start) {
        this.start = start;
    }

    public UserData getEnd() {
        return end;
    }

    public void setEnd(UserData end) {
        this.end = end;
    }
    */

}
