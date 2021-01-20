package com.Sklep.jsp;

import com.model.User;
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
        testUser = new User(1, "login");
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
        Assertions.assertAll(() -> Assertions.assertEquals(User.userLoginValidate(loginPasswords.get(0), loginPasswords.get(1)), 0),
                () -> Assertions.assertEquals(User.userLoginValidate(loginPasswords.get(0), loginPasswords.get(0)), 1),
                () -> Assertions.assertEquals(User.userLoginValidate(loginPasswords.get(2), loginPasswords.get(1)), 2),
                () -> Assertions.assertEquals(User.userLoginValidate(loginPasswords.get(2), loginPasswords.get(2)), 3),
                () -> Assertions.assertEquals(User.userLoginValidate(loginPasswords.get(0)+"'", loginPasswords.get(1)), 4),
                () -> Assertions.assertEquals(User.userLoginValidate(loginPasswords.get(0), loginPasswords.get(1)+"\""), 4),
                () -> Assertions.assertEquals(User.userLoginValidate(null, loginPasswords.get(1)), 100),
                () -> Assertions.assertEquals(User.userLoginValidate(loginPasswords.get(0), null), 100));
    }

    @Test
    void test_userRegisterValidate() {
        List<String> loginPasswords = Arrays.asList("ama.rena@wp.pl", ".@wp.pl", "ama@wppl", "Pawel2", "pawel2", "pawell", "pa", "30-072", "30072", "300722");
        Assertions.assertAll(() -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 0), //Test gdy wszystko jest poprawne.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(1), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 0),     //Test gdy email jest powiedzmy poprawny.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(2), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 1),     //Test gdy domena emaila jest niepoprawna.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(6), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 2),     //Test gdy login jest za krótki.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(4), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 3),     //Test gdy hasła nie są identyczne.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(6), loginPasswords.get(6), "eki", loginPasswords.get(7), "127"), 4),     //Test gdy hasło jest za krótkie.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(4), loginPasswords.get(4), "eki", loginPasswords.get(7), "127"), 5),     //Test gdy hasło nie posiada wielkiej litery
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(5), loginPasswords.get(5), "eki", loginPasswords.get(7), "127"), 5),     //Test gdy hasło nie posiada liczby
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(8), "127"), 6),     //Test gdy kod pocztowy jest zbyt krótki.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(9), "127"), 6),     //Test gdy kod pocztowy nie ma myślnika.
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), ""), 7),      //Test gdy nie podano ulicy
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "Mazowiecka"), 7), //Test gdy nie podano żadnej liczby w polu ulica
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "ek", loginPasswords.get(7), "127"), 8),          //Test gdy jest za krótka nazwa miasta
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), "eki'", loginPasswords.get(7), "127"),9),        //Test gdy podano nieprawidłowy znak w danych
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3)+"\"", loginPasswords.get(3), loginPasswords.get(3), "eki", loginPasswords.get(7), "127"),9),        //Test gdy podano nieprawidłowy znak w danych
                () -> Assertions.assertEquals(User.userRegisterValidate(loginPasswords.get(0), loginPasswords.get(3), null, loginPasswords.get(3), "eki", loginPasswords.get(7), "127"), 100),           //Test gdy wysłany został null do funkcji
                () -> Assertions.assertEquals(User.userRegisterValidate(null, loginPasswords.get(3), loginPasswords.get(3), loginPasswords.get(3), null, loginPasswords.get(7), "127"), 100));          //Test gdy wysłany został null do funkcji

    }
}
