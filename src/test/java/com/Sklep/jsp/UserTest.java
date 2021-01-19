package com.Sklep.jsp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class UserTest {
    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("id", "login");
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
    void test_userLoginValidate() {
        List<String> loginPasswords = Arrays.asList("abcd", "abcdef", "abc");
        Assertions.assertAll(() -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(0), loginPasswords.get(1)), 0),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(0), loginPasswords.get(0)), 1),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(2), loginPasswords.get(1)), 2),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(2), loginPasswords.get(2)), 3),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(0)+"'", loginPasswords.get(1)), 4),
                () -> Assertions.assertEquals(testUser.userLoginValidate(loginPasswords.get(0), loginPasswords.get(1)+"\""), 4));
    }

    @Test
    void test_userRegisterValidate() {
        List<String> loginPasswords = Arrays.asList("ama.rena@wp.pl", ".@wp.pl", "ama@wppl", "Pawel2", "pawel2", "pawell", "pa", "30-072", "30072", "300722");
        Assertions.assertAll(() -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 0), //Test gdy wszystko jest poprawne.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(1), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 0),     //Test gdy email jest powiedzmy poprawny.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(2), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 1),     //Test gdy domena emaila jest niepoprawna.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(6), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 2),     //Test gdy login jest za krótki.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(4), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 3),     //Test gdy hasła nie są identyczne.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(6), loginPasswords.get(6), "eki", loginPasswords.get(7), "127"), 4),     //Test gdy hasło jest za krótkie.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(4), loginPasswords.get(4), "eki", loginPasswords.get(7), "127"), 5),     //Test gdy hasło nie posiada wielkiej litery
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(5), loginPasswords.get(5), "eki", loginPasswords.get(7), "127"), 5),     //Test gdy hasło nie posiada liczby
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(8), "127"), 6),     //Test gdy kod pocztowy jest zbyt krótki.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(9), "127"), 6),     //Test gdy kod pocztowy nie ma myślnika.
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), ""), 7),      //Test gdy nie podano ulicy
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "Mazowiecka"), 7), //Test gdy nie podano żadnej liczby w polu ulica
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki'", loginPasswords.get(7), "127"),8),        //Test gdy podano nieprawidłowy znak w danych
                () -> Assertions.assertEquals(testUser.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3)+"\"", loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"),8));        //Test gdy podano nieprawidłowy znak w danych
    }
}
