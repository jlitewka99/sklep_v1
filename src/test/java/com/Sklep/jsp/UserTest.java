package com.Sklep.jsp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPassword_lenght() {

    }

    @Test
    void testPassword_comparison() {
    }

    @Test
    void testEmail_monkey() {
    }

    @Test
    void testGeneral_lenght() {
    }

    @Test
    void testUserLoginValidate() {
        User testUser = new User("id", "login");
        List<String> loginPasswords = Arrays.asList("abcd", "abcdef", "abc");
        Assertions.assertAll(() -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(0), loginPasswords.get(1)), 0),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(0), loginPasswords.get(0)), 1),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(2), loginPasswords.get(1)), 2),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(2), loginPasswords.get(2)), 3));
    }
}
