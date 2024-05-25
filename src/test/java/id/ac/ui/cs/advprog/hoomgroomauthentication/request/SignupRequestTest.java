package id.ac.ui.cs.advprog.hoomgroomauthentication.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SignupRequestTest {

    private SignupRequest signupRequest;

    @BeforeEach
    public void setUp() {
        signupRequest = new SignupRequest();
    }

    @Test
    public void shouldReturnCorrectFullnameWhenSet() {
        String expectedFullname = "John Doe";
        signupRequest.setFullname(expectedFullname);
        assertEquals(expectedFullname, signupRequest.getFullname());
    }

    @Test
    public void shouldReturnCorrectDobWhenSet() {
        String expectedDob = "1990-01-01";
        signupRequest.setDob(expectedDob);
        assertEquals(expectedDob, signupRequest.getDob());
    }

    @Test
    public void shouldReturnCorrectSexWhenSet() {
        String expectedSex = "Male";
        signupRequest.setSex(expectedSex);
        assertEquals(expectedSex, signupRequest.getSex());
    }

    @Test
    public void shouldReturnCorrectUsernameWhenSet() {
        String expectedUsername = "johndoe";
        signupRequest.setUsername(expectedUsername);
        assertEquals(expectedUsername, signupRequest.getUsername());
    }

    @Test
    public void shouldReturnCorrectEmailWhenSet() {
        String expectedEmail = "johndoe@example.com";
        signupRequest.setEmail(expectedEmail);
        assertEquals(expectedEmail, signupRequest.getEmail());
    }

    @Test
    public void shouldReturnCorrectPasswordWhenSet() {
        String expectedPassword = "password123";
        signupRequest.setPassword(expectedPassword);
        assertEquals(expectedPassword, signupRequest.getPassword());
    }

    @Test
    public void shouldReturnNullWhenFullnameNotSet() {
        assertNull(signupRequest.getFullname());
    }

    @Test
    public void shouldReturnNullWhenDobNotSet() {
        assertNull(signupRequest.getDob());
    }

    @Test
    public void shouldReturnNullWhenSexNotSet() {
        assertNull(signupRequest.getSex());
    }

    @Test
    public void shouldReturnNullWhenUsernameNotSet() {
        assertNull(signupRequest.getUsername());
    }

    @Test
    public void shouldReturnNullWhenEmailNotSet() {
        assertNull(signupRequest.getEmail());
    }

    @Test
    public void shouldReturnNullWhenPasswordNotSet() {
        assertNull(signupRequest.getPassword());
    }
}
