package service;

import entities.ToDo;
import entities.User;
import helpers.DateFormatter;
import interfaces.emailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendToDoEmailByGmailDOS  implements emailService {

    private String sender = "kodigoproject1@gmail.com";
    private String password = "kodigoproject1777";


    public SendToDoEmailByGmailDOS(){};

    @Override
    public void send_Email(User user , ToDo toDo) {
        DateFormatter dateFormatter = new DateFormatter();
        String recipient = user.getEmail();
        String id = String.valueOf(toDo.getId());
        String subjet = toDo.getTitle();
        String description = "Estimado usuario: "+ user.getName() + " se le informa que se ha agregado un nuevo " +
                "ToDo a su lista. \n\nToDo: " + toDo.getTitle() + "\nDescripción: " + toDo.getDescription() + "\nFecha de Entrega: " + dateFormatter.Formatter(toDo.getDate_range().getEndDate(),"EEE, d MMM yyyy h:mm a") ;

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
