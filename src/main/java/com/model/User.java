package com.model;

public class User {
    private int userID;
    private String login;
    private String password;
    private String email;
    private String city;
    private String street;
    private String postCode;
    private Double avgRating;
    private int numberOfRatings;

    public User(int userID) {
        this.userID = userID;
    }

    public User(int userID, String login) {
        this.userID = userID;
        this.login = login;
    }

    public User(String login, String password, String email, String city, String street, String postCode) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public int getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public static int userLoginValidate(String login, String password) {    //Funkcja sprawdzająca wstępną poprawność danych logowania czyli długość loginu większa od 4 i długość hasła większa bądź równa 5.
        if (login == null || password == null) {
            return 100;                                                                                                             //Zabezpieczenie przed wysłaniem nulla do metody
        }
        if (login.contains("'") || login.contains("\"") || password.contains("'") || password.contains("\"")) {
            return 4;                                                //Funkcja zwraca 4 gdy dane zawierają niedozwolone znaki
        }
        if (login.length() >= 4) {
            if (password.length() >= 6) {
                return 0;                                           //Funkcja zwraca 0, gdy dane są wstępnie poprawne.
            } else {
                return 1;                                           //Funkcja zwraca 1, gdy login jest poprawny, ale hasło jest krótsze.
            }
        } else {
            if (password.length() >= 6) {
                return 2;                                           //Funkcja zwraca 2, gdy login jest za krótki ale jest poprawne.
            } else {
                return 3;                                           //Funkcja zwraca 3, gdy obie są nie poprawne.
            }
        }
    }

    public static int userRegisterValidate(String email, String login, String password, String repeatPassword, String city, String postCode, String street) {         //Metoda sprawdza wstępnie dane podane przez użytkownika i zwraca odpowiednie kody błędów jeśli któraś jest niepoprawna.
        if (email == null || login == null || password == null || repeatPassword == null || city == null || postCode == null || street == null) {
            return 100;                                                                                                             //Zabezpieczenie przed wysłaniem nulla do metody
        }
        if (!email.contains("@") || email.lastIndexOf('.') < email.indexOf('@')) {
            return 1;                                                       //Zwraca 1 kiedy podano niepoprawny email.
        }
        if (login.length() < 4) {
            return 2;                                                        //Zwraca 2 kiedy niepoprawny login.
        }
        if (!password.equals(repeatPassword)) {
            return 3;                                                        //Podane hasła nie są identyczne, wtedy zwracany jest kod błędu 3.
        }
        if (password.length() < 6) {
            return 4;                                                        //Jeżeli hasło jest za krótkie to zwracany jest kod błędu 4.
        }
        boolean passwordNumber = false;                                      //Zmienna która będzie sprawdzała czy w haśle jest jedna litera.
        boolean passwordBig = false;                                         //Zmienna która będzie sprawdzała czy w haśle jest jedna wielka litera.
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {    //Sprawdzenie czy dany znak jest wielką literą.
                passwordBig = true;
                if (passwordNumber) {                                        //Jeśli jest liczba oraz wielka litera to pętla jest przerwana.
                    break;
                }
            }
            if ((password.charAt(i) >= '0' && password.charAt(i) <= '9')) {   //Sprawdzenie czy dany znak jest liczbą.
                passwordNumber = true;
                if (passwordBig) {                                          //Jeśli jest liczba oraz wielka litera to pętla jest przerwana.
                    break;
                }
            }
        }
        if (!passwordBig || !passwordNumber) {
            return 5;                                                        //Jeżeli hasło nie posiada wielkiej litery lub nie posiada liczby.
        }
        if (postCode.length() < 6 || !postCode.contains("-")) {
            return 6;                                                        //Jeżeli kod pocztowy jest mniejszy niż 6 lub kod pocztowy nie zawiera znaku - to zwracany jest błąd
        }
        if (street.length() < 1) {
            return 7;                                                          //Jeżeli w miejsce ulicy nie wpisano żadnego znaku to zwracane jest błąd 7
        }
        boolean containsNumber = false;
        for (int i = 0; i < street.length(); i++) {
            if (street.charAt(i) >= '0' && street.charAt(i) <= '9') {
                containsNumber = true;
                break;
            }
        }
        if (!containsNumber) {
            return 7;                                                           //Jeżeli w miejscu ulicy nie wpisano żadnej liczby to zwracany jest błąd 7
        }
        if (city.length() < 3) {
            return 8;                                                           //Jeżeli nazwa miejscowości jest mniejsza od 3 to zwracany jest błąd 8
        }
        if (email.contains("'") || email.contains("\"") || login.contains("'") || login.contains("\"") || password.contains("'") || password.contains("\"") ||
                city.contains("'") || city.contains("\"") || postCode.contains("'") || postCode.contains("\"") || street.contains("'") || street.contains("\"")) {
            return 9;                                                             //Jeśli któraś zmienna zawiera niepoprawny znak to zwracane jest 9
        }
        return 0;
    }
}
