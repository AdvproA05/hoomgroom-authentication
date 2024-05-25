package id.ac.ui.cs.advprog.hoomgroomauthentication.controllers;

import id.ac.ui.cs.advprog.hoomgroomauthentication.models.User;
import id.ac.ui.cs.advprog.hoomgroomauthentication.repository.UserRepository;
import id.ac.ui.cs.advprog.hoomgroomauthentication.request.LoginRequest;
import id.ac.ui.cs.advprog.hoomgroomauthentication.request.SignupRequest;
import id.ac.ui.cs.advprog.hoomgroomauthentication.response.JwtResponse;
import id.ac.ui.cs.advprog.hoomgroomauthentication.response.MessageResponse;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.jwt.JwtUtils;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.services.UserDetailsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder encoder;

    @Mock
    private JwtUtils jwtUtils;

    @InjectMocks
    private AuthController authController;

    @Test
    public void shouldAuthenticateUserWhenCredentialsAreValid() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("validUser");
        loginRequest.setPassword("validPassword");

        User user = new User();
        user.setId(1L);
        user.setUsername("validUser");
        user.setEmail("validUser@gmail.com");

        Authentication authentication = Mockito.mock(Authentication.class);
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);

        when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(jwtUtils.generateJwtToken(authentication)).thenReturn("jwt_token");

        ResponseEntity<?> response = authController.authenticateuser(loginRequest);

        assertEquals(200, response.getStatusCodeValue());
        JwtResponse jwtResponse = (JwtResponse) response.getBody();
        assertEquals("jwt_token", jwtResponse.getAccessToken());
        assertEquals(1, jwtResponse.getId());
        assertEquals("validUser", jwtResponse.getUsername());
        assertEquals("validUser@gmail.com", jwtResponse.getEmail());
    }

    @Test
    public void shouldRegisterUserWhenCredentialsAreUnique() {
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setUsername("newUser");
        signupRequest.setEmail("newUser@gmail.com");
        signupRequest.setPassword("newPassword");

        when(userRepository.existsByUsername(signupRequest.getUsername())).thenReturn(false);
        when(userRepository.existsByEmail(signupRequest.getEmail())).thenReturn(false);

        ResponseEntity<?> response = authController.registerUser(signupRequest);

        assertEquals(200, response.getStatusCodeValue());
        MessageResponse messageResponse = (MessageResponse) response.getBody();
        assertEquals("user registered successfully!", messageResponse.getMessage());
    }

    @Test
    public void shouldNotRegisterUserWhenUsernameIsTaken() {
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setUsername("existingUser");
        signupRequest.setEmail("newUser@gmail.com");
        signupRequest.setPassword("newPassword");

        when(userRepository.existsByUsername(signupRequest.getUsername())).thenReturn(true);

        ResponseEntity<?> response = authController.registerUser(signupRequest);

        assertEquals(400, response.getStatusCodeValue());
        MessageResponse messageResponse = (MessageResponse) response.getBody();
        assertEquals("Error: username is already taken!", messageResponse.getMessage());
    }

    @Test
    public void shouldNotRegisterUserWhenEmailIsTaken() {
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setUsername("newUser");
        signupRequest.setEmail("existingEmail@gmail.com");
        signupRequest.setPassword("newPassword");

        when(userRepository.existsByEmail(signupRequest.getEmail())).thenReturn(true);

        ResponseEntity<?> response = authController.registerUser(signupRequest);

        assertEquals(400, response.getStatusCodeValue());
        MessageResponse messageResponse = (MessageResponse) response.getBody();
        assertEquals("Error: Email is already in use!", messageResponse.getMessage());
    }
}
