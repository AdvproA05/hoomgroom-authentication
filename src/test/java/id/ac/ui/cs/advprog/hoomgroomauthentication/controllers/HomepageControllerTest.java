package id.ac.ui.cs.advprog.hoomgroomauthentication.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomepageControllerTest {

    private HomepageController homepageController;

    @BeforeEach
    public void setup() {
        homepageController = new HomepageController();
    }

    @Test
    @DisplayName("Should return homepage when homepage endpoint is hit")
    public void shouldReturnHomepageWhenHomepageEndpointIsHit() {
        String result = homepageController.homepage();
        assertEquals("homepage", result);
    }
}
