package com.Sklep.jsp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {
    private Auction auctionTest;
    @BeforeEach
    void setUp(){
        auctionTest = new Auction("id","title","description",37.21);
    }
    @Test
    void test_auctionValidate(){
        Date tomorrowDate = new Date(System.currentTimeMillis()+86400); //Aktualna data plus jeden dzień
        Assertions.assertAll(
                () -> Assertions.assertEquals(auctionTest.auctionValidate("title", "description", 2, "moda", tomorrowDate),0));
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