package id.ac.ui.cs.advprog.hoomgroomauthentication.controllers;

import id.ac.ui.cs.advprog.hoomgroomauthentication.response.MessageResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest {

    private UserController userController;

    @BeforeEach
    public void setup() {
        userController = new UserController();
    }

    @Test
    @DisplayName("Should return server status message for all access")
    public void shouldReturnServerStatusMessageForAllAccess() {
        MessageResponse result = userController.allAccess();
        assertEquals("Server is up.....", result.getMessage());
    }

    @Test
    @DisplayName("Should return authenticated user message for user access")
    public void shouldReturnAuthenticatedUserMessageForUserAccess() {
        MessageResponse result = userController.userAccess();
        assertEquals("Congratulations! You are an authenticated user.", result.getMessage());
    }
}