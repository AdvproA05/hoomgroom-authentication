package id.ac.ui.cs.advprog.hoomgroomauthentication.security;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.jwt.AuthEntryPointJwt;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.jwt.AuthTokenFilter;
import id.ac.ui.cs.advprog.hoomgroomauthentication.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    private HttpSecurity http;

    @Test
    public void testCorsAndCsrfConfiguration() throws Exception {
        http = mock(HttpSecurity.class);
        when(http.cors(withDefaults())).thenReturn(http);
        when(http.csrf(any())).thenReturn(http);
        when(http.exceptionHandling(any())).thenReturn(http);
        when(http.sessionManagement(any())).thenReturn(http);
        when(http.authorizeHttpRequests(any())).thenReturn(http);
        when(http.addFilterBefore(any(), eq(UsernamePasswordAuthenticationFilter.class))).thenReturn(http);
        webSecurityConfig.filterChain(http);
        verify(http).cors(withDefaults());
        verify(http).csrf(any());
    }

    @Test
    public void testExceptionHandlingConfiguration() throws Exception {
        http = mock(HttpSecurity.class);
        when(http.cors(withDefaults())).thenReturn(http);
        when(http.csrf(any())).thenReturn(http);
        when(http.exceptionHandling(any())).thenReturn(http);
        when(http.sessionManagement(any())).thenReturn(http);
        when(http.authorizeHttpRequests(any())).thenReturn(http);
        when(http.addFilterBefore(any(), eq(UsernamePasswordAuthenticationFilter.class))).thenReturn(http);
        webSecurityConfig.filterChain(http);
        verify(http).exceptionHandling(any());
    }

    @Test
    public void testSessionManagementConfiguration() throws Exception {
        http = mock(HttpSecurity.class);
        when(http.cors(withDefaults())).thenReturn(http);
        when(http.csrf(any())).thenReturn(http);
        when(http.exceptionHandling(any())).thenReturn(http);
        when(http.sessionManagement(any())).thenReturn(http);
        when(http.authorizeHttpRequests(any())).thenReturn(http);
        when(http.addFilterBefore(any(), eq(UsernamePasswordAuthenticationFilter.class))).thenReturn(http);
        webSecurityConfig.filterChain(http);
        verify(http).sessionManagement(any());
    }

    @Test
    public void testAuthorizeRequestsConfiguration() throws Exception {
        http = mock(HttpSecurity.class);
        when(http.cors(withDefaults())).thenReturn(http);
        when(http.csrf(any())).thenReturn(http);
        when(http.exceptionHandling(any())).thenReturn(http);
        when(http.sessionManagement(any())).thenReturn(http);
        when(http.authorizeHttpRequests(any())).thenReturn(http);
        when(http.addFilterBefore(any(), eq(UsernamePasswordAuthenticationFilter.class))).thenReturn(http);
        webSecurityConfig.filterChain(http);
        verify(http).authorizeHttpRequests(any());
    }

    @Test
    public void testAddFilterBefore() throws Exception {
        http = mock(HttpSecurity.class);
        when(http.cors(withDefaults())).thenReturn(http);
        when(http.csrf(any())).thenReturn(http);
        when(http.exceptionHandling(any())).thenReturn(http);
        when(http.sessionManagement(any())).thenReturn(http);
        when(http.authorizeHttpRequests(any())).thenReturn(http);
        when(http.addFilterBefore(any(), eq(UsernamePasswordAuthenticationFilter.class))).thenReturn(http);
        webSecurityConfig.filterChain(http);
        verify(http).addFilterBefore(any(AuthTokenFilter.class), eq(UsernamePasswordAuthenticationFilter.class));
    }

    @Test
    void passwordEncoderBeanCreated() {
        PasswordEncoder passwordEncoder = webSecurityConfig.passwordEncoder();
        assertNotNull(passwordEncoder);
    }

    @Test
    void authenticationManagerBeanCreated() throws Exception {
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationConfiguration.getAuthenticationManager()).thenReturn(authenticationManager);

        AuthenticationManager actualAuthenticationManager = webSecurityConfig.authenticationManager(authenticationConfiguration);

        assertNotNull(actualAuthenticationManager);
        assert actualAuthenticationManager.equals(authenticationManager);
    }

    @Test
    void authenticationManagerConfiguredCorrectly() throws Exception {
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationConfiguration.getAuthenticationManager()).thenReturn(authenticationManager);

        AuthenticationManager result = webSecurityConfig.authenticationManager(authenticationConfiguration);

        verify(authenticationConfiguration).getAuthenticationManager();
        assertNotNull(result);
        assert result.equals(authenticationManager);
    }

}

