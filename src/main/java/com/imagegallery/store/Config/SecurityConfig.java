package com.imagegallery.store.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//All the security related problem resolve the Config section.
@Configuration //Configuration annotation indicates that this class has Bean definition for spring context that can be used in whole application.
@Repository
public class SecurityConfig {
    //Bean annotation applied on method to specify that it returns a bean to be managed by spring context
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //Define the mail service
    public Boolean sendMail(String from, String to, String subject, String message) {
        Boolean f = false;
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        //Session for authentication.
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ibrahimhossain495@gmail.com","ftahcegwxmepbzaz");
            }
        });
        MimeMessage mimemessage = new MimeMessage(session);
        //mimeMessage
        try {
            mimemessage.setFrom(new InternetAddress(from));
            mimemessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimemessage.setSubject(subject);
            mimemessage.setContent(message, "text/HTML"); //used to pass html content to the email.
            Transport.send(mimemessage);
            f=true;
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return f;
    }
}
//End mail service

