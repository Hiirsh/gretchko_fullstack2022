package telran.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.user.model.User;

class PasswordTest {
    User user;
    String email = "vasya@gmail.com";
    String password = "3343HHgfdw@#";

    @BeforeEach
    void setUp() throws Exception {
        user = new User(email, password);
    }

    @Test
    void testCorrectPassword() {
        user.setPassword("33Hgfdw(()(");
        assertEquals("33Hgfdw(()(", user.getPassword());
    }

    @Test
    void testWithoutUpper() {
        user.setPassword("23445kkdwkjhf//*");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testWithoutLower() {
        user.setPassword("23445KKSWA//*");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testWithoutSpec() {
        user.setPassword("23445KKSWAadw");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testWithoutDig() {
        user.setPassword("$%dwKKSWAadw");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testLength() {
        user.setPassword("$%wER1");
        assertEquals(email, user.getEmail());
    }

}
