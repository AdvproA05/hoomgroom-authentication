package id.ac.ui.cs.advprog.hoomgroomauthentication.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginRequestTest {

    private LoginRequest loginRequest;

    @BeforeEach
    public void setUp() {
        loginRequest = new LoginRequest();
    }

    @Test
    public void shouldReturnCorrectUsernameWhenSet() {
        String expectedUsername = "testUsername";
        loginRequest.setUsername(expectedUsername);
        assertEquals(expectedUsername, loginRequest.getUsername());
    }

    @Test
    public void shouldReturnCorrectPasswordWhenSet() {
        String expectedPassword = "testPassword";
        loginRequest.setPassword(expectedPassword);
        assertEquals(expectedPassword, loginRequest.getPassword());
    }

    @Test
    public void shouldReturnNullWhenUsernameNotSet() {
        assertNull(loginRequest.getUsername());
    }

    @Test
    public void shouldReturnNullWhenPasswordNotSet() {
        assertNull(loginRequest.getPassword());
    }
}
