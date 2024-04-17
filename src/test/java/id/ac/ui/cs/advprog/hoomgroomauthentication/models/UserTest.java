package id.ac.ui.cs.advprog.hoomgroomauthentication.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setFullname("Nanang Ismail");
        this.user.setDob("01/01/1990");
        this.user.setSex("Male");
        this.user.setUsername("nangis");
        this.user.setEmail("nanangis@gmail.com");
        this.user.setPassword("nangskuy15");
    }

    @Test
    void testGetFullname() {
        assertEquals("Nanang Ismail", this.user.getFullname());
    }

    @Test
    void testGetDob() {
        assertEquals("01/01/1990", this.user.getDob());
    }

    @Test
    void testGetSex() {
        assertEquals("Male", this.user.getSex());
    }

    @Test
    void testGetUsername() {
        assertEquals("nangis", this.user.getUsername());
    }

    @Test
    void testGetEmail() {
        assertEquals("nanangis@gmail.com", this.user.getEmail());
    }

    @Test
    void testGetPassword() {
        assertEquals("nangskuy15", this.user.getPassword());
    }
}
