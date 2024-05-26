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
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    private final WebSecurityConfig webSecurityConfigs = new WebSecurityConfig();

    @Test
    void passwordEncoderBeanCreated() {
        PasswordEncoder passwordEncoder = webSecurityConfig.passwordEncoder();
        assertNotNull(passwordEncoder);
    }

    @Test
    void authenticationJwtTokenFilterBeanCreated() {
        AuthTokenFilter authTokenFilter = webSecurityConfig.authenticationJwtTokenFilter();
        assertNotNull(authTokenFilter);
    }

    @Test
    void authenticationManagerBeanCreated() throws Exception {
        AuthenticationConfiguration authenticationConfiguration = mock(AuthenticationConfiguration.class);

        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);

        when(authenticationConfiguration.getAuthenticationManager()).thenReturn(authenticationManager);

        AuthenticationManager actualAuthenticationManager = webSecurityConfigs.authenticationManager(authenticationConfiguration);

        assertNotNull(actualAuthenticationManager);
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

