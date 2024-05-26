package id.ac.ui.cs.advprog.hoomgroomauthentication.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageResponseTest {

    private MessageResponse messageResponse;

    @BeforeEach
    public void setUp() {
        messageResponse = new MessageResponse("Initial message");
    }

    @Test
    public void shouldReturnCorrectMessageWhenSet() {
        String expectedMessage = "New message";
        messageResponse.setMessage(expectedMessage);
        assertEquals(expectedMessage, messageResponse.getMessage());
    }

    @Test
    public void shouldReturnInitialMessageWhenNotSet() {
        assertEquals("Initial message", messageResponse.getMessage());
    }
}
