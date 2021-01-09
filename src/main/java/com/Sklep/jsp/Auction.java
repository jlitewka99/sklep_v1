package com.Sklep.jsp;

public class Auction
{
private UserData start;
private UserData end;
private String description;
private String auctionID;
private String name;
private double price;
private User seller;//takie warzywo

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
