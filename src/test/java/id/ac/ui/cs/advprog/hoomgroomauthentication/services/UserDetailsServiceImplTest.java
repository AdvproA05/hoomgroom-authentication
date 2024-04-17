package id.ac.ui.cs.advprog.hoomgroomauthentication.services;

import id.ac.ui.cs.advprog.hoomgroomauthentication.models.User;
import id.ac.ui.cs.advprog.hoomgroomauthentication.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void testLoadUserByUsernameExist() {

        User user = new User();
        user.setUsername("nangis");
        user.setPassword("nangskuy15");

        when(userRepository.findByUsername("nangis")).thenReturn(Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("nangis");

        assertEquals("nangis", userDetails.getUsername());
        assertEquals("nangskuy15", userDetails.getPassword());
    }

    @Test
    void testLoadUserByUsernameNotFound() {
        String username = "gaaadananang";

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(username));
    }
}

