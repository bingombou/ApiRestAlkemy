package com.alkemy.ong.sendgrid;

import com.alkemy.ong.domain.mail.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DefaultEmailService implements EmailService {

    private String emailSender = "welcome.ong@hotmail.com";


    public DefaultEmailService() {
    }

    @Override
    public void sendEmail(String email) {
        Email from = new Email(emailSender);
        Email to = new Email(email);
        String subject = "Alkemy ONG";
        Content content = new Content("text/plain", "content");
        Mail mail = new Mail(from, subject, to, content);
        send(mail);
    }

    private Response send(Mail mail) {

        com.sendgrid.SendGrid sg = new com.sendgrid.SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        Response response = null;

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return response;

    }



}