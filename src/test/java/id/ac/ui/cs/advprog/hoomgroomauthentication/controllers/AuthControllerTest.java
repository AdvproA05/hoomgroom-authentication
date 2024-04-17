package id.ac.ui.cs.advprog.hoomgroomauthentication.controllers;

import id.ac.ui.cs.advprog.hoomgroomauthentication.models.User;
import id.ac.ui.cs.advprog.hoomgroomauthentication.request.LoginRequest;
import id.ac.ui.cs.advprog.hoomgroomauthentication.response.JwtResponse;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.jwt.JwtUtils;
import id.ac.ui.cs.advprog.hoomgroomauthentication.services.UserDetailsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtils jwtUtils;

    @InjectMocks
    private AuthController authController;

    @Test
    public void testAuthenticateUser() {
        // Arrange
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("nangis");
        loginRequest.setPassword("nangskuy15");

        User user = new User();
        user.setId(1L);
        user.setUsername("nangis");
        user.setEmail("nanangis@gmail.com");

        Authentication authentication = Mockito.mock(Authentication.class);
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);

        when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(jwtUtils.generateJwtToken(authentication)).thenReturn("jwt_token");

        // Act
        ResponseEntity<?> response = authController.authenticateuser(loginRequest);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        JwtResponse jwtResponse = (JwtResponse) response.getBody();
        assertEquals("jwt_token", jwtResponse.getAccessToken());
        assertEquals(1, jwtResponse.getId());
        assertEquals("nangis", jwtResponse.getUsername());
        assertEquals("nanangis@gmail.com", jwtResponse.getEmail());
    }
}
