package id.ac.ui.cs.advprog.hoomgroomauthentication.security.services;

import id.ac.ui.cs.advprog.hoomgroomauthentication.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDetailsImplTest {

    private UserDetailsImpl userDetails;

    @BeforeEach
    public void setup() {
        userDetails = new UserDetailsImpl(1L, "username", "email", "password");
    }

    @Test
    public void shouldReturnCorrectId() {
        assertEquals(1L, userDetails.getId());
    }

    @Test
    public void shouldReturnCorrectUsername() {
        assertEquals("username", userDetails.getUsername());
    }

    @Test
    public void shouldReturnCorrectEmail() {
        assertEquals("email", userDetails.getEmail());
    }

    @Test
    public void shouldReturnCorrectPassword() {
        assertEquals("password", userDetails.getPassword());
    }

    @Test
    public void shouldReturnTrueForAccountNonExpired() {
        assertTrue(userDetails.isAccountNonExpired());
    }

    @Test
    public void shouldReturnTrueForAccountNonLocked() {
        assertTrue(userDetails.isAccountNonLocked());
    }

    @Test
    public void shouldReturnTrueForCredentialsNonExpired() {
        assertTrue(userDetails.isCredentialsNonExpired());
    }

    @Test
    public void shouldReturnTrueForEnabled() {
        assertTrue(userDetails.isEnabled());
    }

    @Test
    public void shouldReturnNullForAuthorities() {
        assertNull(userDetails.getAuthorities());
    }

    @Test
    public void shouldReturnTrueForEqualObjects() {
        UserDetailsImpl userDetails2 = new UserDetailsImpl(1L, "username", "email", "password");
        assertTrue(userDetails.equals(userDetails2));
    }

    @Test
    public void shouldReturnFalseForNonEqualObjects() {
        UserDetailsImpl userDetails2 = new UserDetailsImpl(2L, "username", "email", "password");
        assertFalse(userDetails.equals(userDetails2));
    }

    @Test
    public void shouldBuildUserDetailsFromUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setEmail("email");
        user.setPassword("password");

        UserDetailsImpl userDetailsFromUser = UserDetailsImpl.build(user);

        assertEquals(userDetails, userDetailsFromUser);
    }
}
