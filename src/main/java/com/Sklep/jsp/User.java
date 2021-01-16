package com.Sklep.jsp;

public class User {
    private String userID;
    private String login;
    private String password;
    private Status status;
    private Double rating;

    public User(String userID, String login, Status status, Double rating) { // constructor
        this.userID = userID;
        this.login = login;
        this.status = status;
        this.rating = rating;
    }

    public User(String userID, String login) {
        this.userID = userID;
        this.login = login;
    }

    public String getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
    }

    public Status getStatus() {
        return status;
    }

    public Double getRating() {
        return rating;
    }

    public static int userLoginValidate(String login, String password) {    //Funckja sprawdzająca wstępną poprawność danych logowania czyli długość loginu większa od 4 i długość hasła większa bądź równa 5.
        if (login.length() >= 4) {
            if (password.length() >= 6) {
                return 0;                                           //Funkcja zwraca 0, gdy dane są wstępnie poprawne.
            } else {
                return 1;                                           //Funkcja zwraca 1, gdy login jest poprawny, ale hasło jest krótsze.
            }
        } else {
            if (password.length() >= 6) {
                return 2;                                           //Funkcja zwraca 3, gdy login jest za krótki ale jest poprawne.
            } else {
                return 3;                                           //Funkcja zwraca 4, gdy obie są nie poprawne.
            }
        }
    }

    public static int userRegisterValidate(String email, String login, String password, String repeatPassword, String city, String postCode) {
        if (!email.contains("@") || email.lastIndexOf('.') < email.indexOf('@')) {
            return 1;                                                       //Niepoprawny email
        }
        if (login.length() < 4) {
            return 2;                                                        //Niepoprawny login
        }
        if (!password.equals(repeatPassword)) {
            return 3;                                                        //Podane hasła nie są identyczne
        }
        if (password.length() < 6) {
            return 4;                                                        //Za krótkie hasło
        }
        boolean passwordLetter = false;
        boolean passwordBig = false;
        for (int i = 0; i < password.length(); i++) {
            if ((password.charAt(i) >= 65 && password.charAt(i) <= 90)) {
                passwordBig = true;
                if (passwordLetter) {
                    break;
                }
            }
            if ((password.charAt(i) >= 48 && password.charAt(i) <= 57)) {
                passwordLetter = true;
                if (passwordBig) {
                    break;
                }
            }
        }
        if (!passwordBig && !passwordLetter) {
            return 5;                                                        //Za słabe hasło
        }
        if (postCode.length() < 6 || !postCode.contains("-")) {
            return 6;                                                       //Zły kod pocztowy
        }
        return 0;
    }
    /*
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
    }*/
    /*
     * poprawić zgodnie z tymi danymi którę są w tej klasie teraz
     * bo były rzeczy które rozdzielimy na inne klasy
     * */
}
