package id.ac.ui.cs.advprog.hoomgroomauthentication.security;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.jwt.AuthEntryPointJwt;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.jwt.AuthTokenFilter;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.mockito.Mockito.*;
import static org.springframework.security.config.Customizer.withDefaults;

@ExtendWith(MockitoExtension.class)
class WebSecurityConfigTest {

    @Mock
    private AuthEntryPointJwt authEntryPointJwt;

    @Mock
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private AuthenticationConfiguration authenticationConfiguration;

    @InjectMocks
    private WebSecurityConfig webSecurityConfig;

    @Test
    void passwordEncoderBeanCreated() {
        PasswordEncoder passwordEncoder = webSecurityConfig.passwordEncoder();
        assert passwordEncoder != null;
    }

    @Test
    void authenticationJwtTokenFilterBeanCreated() {
        AuthTokenFilter authTokenFilter = webSecurityConfig.authenticationJwtTokenFilter();
        assert authTokenFilter != null;
    }

    @Test
    void authenticationManagerConfiguredCorrectly() throws Exception {
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationConfiguration.getAuthenticationManager()).thenReturn(authenticationManager);

        AuthenticationManager result = webSecurityConfig.authenticationManager(authenticationConfiguration);

        verify(authenticationConfiguration).getAuthenticationManager();

        assert result != null;
        assert result.equals(authenticationManager);
    }

}

