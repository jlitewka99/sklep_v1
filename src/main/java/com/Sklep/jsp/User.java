package com.Sklep.jsp;

public class User
{
    private String password;
    private String userID;
    private Status status;
    private double opinion;
    private String login;
    private String name;
    private String surname;
    private String email;
    private UserData data_br;
    private Address address;

    public User(String password, double opinion, String login, String name, String surname, String email, UserData data_br, Address address) {
        this.password = password;
        this.userID = "1";
        this.status = Status.New;
        this.opinion = opinion;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.data_br = data_br;
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getOpinion() {
        return opinion;
    }

    public void setOpinion(double opinion) {
        this.opinion = opinion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserData getData_br() {
        return data_br;
    }

    public void setData_br(UserData data_br) {
        this.data_br = data_br;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
