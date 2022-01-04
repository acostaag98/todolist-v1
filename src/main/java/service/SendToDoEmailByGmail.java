package service;

import entities.ToDo;
import entities.User;
import interfaces.emailService;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendToDoEmailByGmail implements emailService {

    private String sender = "developertest693@gmail.com";
    private String password = "prueba123";



    public SendToDoEmailByGmail(){};

    @Override
    public void send_Email(User user , ToDo toDo) {

        String recipient = user.getEmail();
        String id = String.valueOf(toDo.getId());
        String subjet = toDo.getTitle();
        String description = "Estimado usuario: "+ user.getName() + " se le informa que se ha agregado un nuevo " +
                "ToDo a su lista. \n\nToDo: " + toDo.getTitle() + "\nDescripción: " + toDo.getDescription();

        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }

        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subjet);
            message.setText(description);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
