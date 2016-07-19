package vetrov.denis.todolist.services;

/**
 * Created by Denis on 19.07.2016.
 */
import org.springframework.stereotype.Service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

    private final static String USERNAME = "holydenez@gmail.com";
    private final static String PASSWORD = "Denezzz11322117";

    public void send(final String recipientEmail, final String subject, final String text) {
        Properties props = new Properties() {{
            put("mail.smtp.auth", "true");
            put("mail.smtp.starttls.enable", "true");
            put("mail.smtp.host", "smtp.gmail.com");
            put("mail.smtp.ssl.trust", "smtp.gmail.com");
            put("mail.smtp.port", "587");
        }};

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session) {{
                setFrom("to-do-list@gmail.com");
                setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
                setSubject(subject);
                setText(text);
            }};
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
