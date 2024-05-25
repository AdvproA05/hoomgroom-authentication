package id.ac.ui.cs.advprog.hoomgroomauthentication.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JwtResponseTest {

    private JwtResponse jwtResponse;

    @BeforeEach
    public void setUp() {
        jwtResponse = new JwtResponse("token", 1L, "username", "email");
    }

    @Test
    public void shouldReturnCorrectAccessTokenWhenSet() {
        String expectedToken = "newToken";
        jwtResponse.setAccessToken(expectedToken);
        assertEquals(expectedToken, jwtResponse.getAccessToken());
    }

    @Test
    public void shouldReturnCorrectTokenTypeWhenSet() {
        String expectedType = "newType";
        jwtResponse.setTokenType(expectedType);
        assertEquals(expectedType, jwtResponse.getTokenType());
    }

    @Test
    public void shouldReturnCorrectIdWhenSet() {
        Long expectedId = 2L;
        jwtResponse.setId(expectedId);
        assertEquals(expectedId, jwtResponse.getId());
    }

    @Test
    public void shouldReturnCorrectUsernameWhenSet() {
        String expectedUsername = "newUsername";
        jwtResponse.setUsername(expectedUsername);
        assertEquals(expectedUsername, jwtResponse.getUsername());
    }

    @Test
    public void shouldReturnCorrectEmailWhenSet() {
        String expectedEmail = "newEmail";
        jwtResponse.setEmail(expectedEmail);
        assertEquals(expectedEmail, jwtResponse.getEmail());
    }
}
