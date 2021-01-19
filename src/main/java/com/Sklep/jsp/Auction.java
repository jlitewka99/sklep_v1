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

    public int auctionValidate(String title, String description, int pictureCount, String category, Date endDate, double price) {    //Metoda sprawdzająca dane wysłane przy tworzeniu aukcji
        if(title==null || description==null  || category==null || endDate==null){
            return 100;                                                                                                             //Zabezpieczenie przed wysłaniem nulla do metody
        }
        if (title.length() < 3 || title.length() > 40) {
            return 1;                                                                                                               //Zwracane jest 1, gdy tytuł jest za krótki lub za długi
        }
        if (description.length() < 3 || description.length() > 500) {
            return 2;                                                                                                               //Zwracane jest 2, gdy opis jest za krótki lub za długi
        }
        if (pictureCount < 1) {
            return 3;                                                                                                               //Zwracane jest 3, gdy nie wysłano zdjęć
        }
        if (!categoryList.contains(category)) {
            return 4;                                                                                                               //Zwracane jest 4 gdy podano kategorię nie znajdującą się na liście kategorii
        }
        if (endDate.before(new Date(System.currentTimeMillis()))) {
            return 5;                                                                                                               //Zwracane jest 5 gdy data zakończenia jest mniejsza od obecnej daty
        }
        if (price <= 0) {
            return 6;                                                                                                               //Zwracane jest 6 gdy cena jest mniejsza od 0
        }
        if (title.contains("'") || title.contains("\"") || description.contains("'") || description.contains("\"") || category.contains("'") || category.contains("\"")) {
            return 7;                                                                                                               //Jeśli któraś zmienna zawiera niepoprawny znak to zwracane jest 7
        }

        return 0;                                                                                                                   //Zwracane jest 0, gdy podano właściwe dane
    }

    public static String deleteIllegalCharacters(String phrase) {                                                   //Metoda zwracająca ciąg znaków po usunięciu znaków niedozwolonych czyli " oraz '
        if(phrase==null){
            return "";
        }
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == 39 || phrase.charAt(i) == 34) {
                phrase = phrase.substring(0, i) + phrase.substring(i + 1);
            }
        }
        return phrase;
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

}
