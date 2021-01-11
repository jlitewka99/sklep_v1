package com.Sklep.jsp;

public class User {
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

    public User(String password,String password2, String login, String name, String surname, String email, UserData data_br, Address address) {
        int returner = 0;

        returner = data_checking(password, password2, login, name, surname, email);//sprawdzenie poszczególnych danych czy są dobre
        //nie wiem jak to chcecie połączyć wię cnapiszę to w taki sposób żeby łatwo było to zmienić??? - Bartek

        if (returner == 0) {
            this.password = password;
            this.userID = "1";
            this.status = Status.New;
            this.login = login;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.data_br = data_br;
            this.address = address;
        } else {
            System.out.println(" Mamy do czynienia z blendem nr. " + returner);
        }
    }




public int data_checking(String password,String password2, String login, String name, String surname, String email)
        {

            if(password_lenght( password)){return 1;}
            if(password_comparison(password, password2)) {return 2;}
            if(email_monkey(email)){return 3;}
            if(general_lenght(login)){return 4;}
            if(general_lenght(name)){return 5;}
            if(general_lenght(surname)){return 6;}
            //porównania związane z adresem i data trzeba zrobić w tamtych klasach i je tu wywołać po prostu
            return 0;

        }


public boolean password_lenght(String password)
{
    if(password.length() < 6) {
        return true;
    }
    else
        return false;
}
public boolean password_comparison(String password, String password2)
    {
        if(password != password2) {
            return true;
        }
        else
            return false;
    }
public boolean email_monkey(String email) {
    if(email.indexOf("@") < 0) {
        return true;
    }
    else
        return false;
}
    public boolean general_lenght(String example)
    {
        if(password.length() < 3) {
            return true;
        }
        else
            return false;
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
