package com.Sklep.jsp;

public class Payment
{
private UserData data;
private String p_ID;
private Auction product;
private User who;
private String setails;

    public Payment(UserData data, String p_ID, Auction product, User who, String setails) {
        this.data = data;
        this.p_ID = p_ID;
        this.product = product;
        this.who = who;
        this.setails = setails;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public String getP_ID() {
        return p_ID;
    }

    public void setP_ID(String p_ID) {
        this.p_ID = p_ID;
    }

    public Auction getProduct() {
        return product;
    }

    public void setProduct(Auction product) {
        this.product = product;
    }

    public User getWho() {
        return who;
    }

    public void setWho(User who) {
        this.who = who;
    }

    public String getSetails() {
        return setails;
    }

    public void setSetails(String setails) {
        this.setails = setails;
    }
}
