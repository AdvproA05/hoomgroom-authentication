package id.ac.ui.cs.advprog.hoomgroomauthentication.security.jwt;

import id.ac.ui.cs.advprog.hoomgroomauthentication.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class JwtUtilsTest {

    private JwtUtils jwtUtils;

    @Mock
    private Authentication authentication;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        jwtUtils = new JwtUtils();
    }

    @Test
    public void shouldGenerateValidJwtToken() {
        when(authentication.getPrincipal()).thenReturn(new UserDetailsImpl(1L, "username", "email", "password"));
        String token = jwtUtils.generateJwtToken(authentication);
        assertTrue(jwtUtils.validateJwtToken(token));
    }

    @Test
    public void shouldReturnUsernameFromJwtToken() {
        when(authentication.getPrincipal()).thenReturn(new UserDetailsImpl(1L, "username", "email", "password"));
        String token = jwtUtils.generateJwtToken(authentication);
        assertEquals("username", jwtUtils.getUserNameFromJwtToken(token));
    }

    @Test
    public void shouldInvalidateMalformedJwtToken() {
        assertFalse(jwtUtils.validateJwtToken("malformedToken"));
    }
}