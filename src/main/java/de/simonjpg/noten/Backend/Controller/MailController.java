package de.simonjpg.noten.Backend.Controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class MailController {
    private Session session;
    private String code = "";
    private final String username = "email";
    private final String password = "password";

    public MailController() {
        init();
    }

    private void init() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        prepareRandomCode();
    }

    private void prepareRandomCode() {
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code += random.nextInt(9);
        }
    }

    public boolean sendMail(String clientEmail) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(clientEmail));
            message.setSubject("Verifizierungsmail Notenübersicht");
            message.setText("Dein Verifizierungstoken lautet:" + code + ". \nFalls du dein Passwort nicht zurücksetzen willst, kannst du diese Mail ignorieren.\nDiese Email wurde automatisch versendet und beantwortet keine einkommenden Mails.");
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            System.err.printf("Sending verification email failed: %s", e.getMessage());
            return false;
        }
    }

    public String getCode() {
        return code;
    }
}
