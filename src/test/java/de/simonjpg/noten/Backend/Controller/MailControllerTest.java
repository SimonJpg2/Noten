package de.simonjpg.noten.Backend.Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailControllerTest {

    @Test
    void sendMail() {
        MailController mailController = new MailController();
        assertTrue(mailController.sendMail("test.mail@gmail.com"));
    }
}