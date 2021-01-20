package com.Sklep.jsp;

import com.model.Auction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

class AuctionTest {
    private Auction auctionTest;
    @BeforeEach
    void setUp(){
        auctionTest = new Auction(1,"title","description",37.21);
    }
    @Test
    void test_auctionValidate(){
        //String zawierający 446 znaków
        String longString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        Date tomorrowDate = new Date(System.currentTimeMillis()+(24*60*60*1000)); //Aktualna data plus jeden dzień (jutro)
        Date yesterdayDate = new Date(System.currentTimeMillis()-(24*60*60*1000)); //Aktualna data plus jeden dzień (dziś)
        Assertions.assertAll(
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description", 2, "moda", tomorrowDate, 15.50),0),  //Zwracane jest 0, gdy podano właściwe dane
                () -> Assertions.assertEquals(auctionTest.auctionValidate("t", "description", 2, "moda", tomorrowDate, 15.50),1),     //Zwracane jest 1, gdy tytuł jest za krótki
                () -> Assertions.assertEquals(auctionTest.auctionValidate(longString, "description", 2, "moda", tomorrowDate, 15.50),1),  //Zwracane jest 1, gdy tytuł jest za długi
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "de", 2, "moda", tomorrowDate, 15.50),2),          //Zwracane jest 2, gdy opis jest za krótki
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", longString, 2, "moda", tomorrowDate, 15.50),2),            //Zwracane jest 2, gdy opis jest za długi
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description", 0, "moda", tomorrowDate, 15.50),3),    //Zwracane jest 3, gdy nie wysłano zdjęć
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description", 4, "moda", tomorrowDate, 15.50),3),       //Zwracane jest 3, gdy wysłano za dużą ilość zdjęć
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description", 2, "benzynka", tomorrowDate, 15.50),4), //Zwracane jest 4 gdy podano kategorię nie znajdującą się na liście kategorii
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description", 2, "moda", yesterdayDate, 15.50),5), //Zwracane jest 5 gdy data zakończenia jest mniejsza od obecnej daty
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description", 2, "moda", tomorrowDate, 0),6),     //Zwracane jest 6 gdy cena jest mniejsza od 0.
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title'", "description", 2, "moda", tomorrowDate, 15.50),7),  //Zwracane jest 7 gdy podano niepoprawny znak
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description\"", 2, "moda", tomorrowDate, 15.50),7),    //Zwracane jest 7 gdy podano niepoprawny znak
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", null, 2, "moda", tomorrowDate, 15.50),100),              //Zwracane jest 100 gdy wysłano null
                () -> Assertions.assertEquals(auctionTest.auctionValidate(null, null, 2, null, tomorrowDate, 15.50),100));                  //Zwracane jest 100 gdy wysłano null
    }

    @Test
    void test_deleteIllegalCharacters(){
        Assertions.assertAll(()->Assertions.assertEquals(Auction.filter("string"),"string"),
                ()->Assertions.assertEquals(Auction.filter("\"string"),"string"),
                ()->Assertions.assertEquals(Auction.filter("stri\"ng"),"string"),
                ()->Assertions.assertEquals(Auction.filter("\"string'"),"string"),
                ()->Assertions.assertEquals(Auction.filter(null),""));

    }

    @Test
    void getStart() {
    }

    @Test
    void setStart() {
    }

    @Test
    void getEnd() {
    }

    @Test
    void setEnd() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void getAuctionID() {
    }

    @Test
    void setAuctionID() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void getSeller() {
    }

    @Test
    void setSeller() {
    }
}