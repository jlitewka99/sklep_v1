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
}
