package com.guesthouse.service.client.account.register;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.guesthouse.domain.user.User;
import com.guesthouse.service.email.EmailResponse;
import com.guesthouse.service.email.EmailService;
import com.guesthouse.service.email.Mail;

@Service
public class ActivationEmailService {

    @Autowired
    private EmailService emailService;

    @Value( "${email.do.not.reply}" )
    private String emailFrom;

    @Value( "${application.url}" )
    private String domain;

    @Autowired
    private MessageSource resourceBundleMessageSource;


    public EmailResponse sentActivationEmail( User user, Locale locale ) {

        String subject = createSubject( locale );

        Map<String, Object> model = new HashMap<>();
        model.put( "subject", subject );
        model.put( "name", user.getFirstName() );
        model.put( "dear", createSalutation( locale ) );
        model.put( "link", prepareActivationLink() );
        model.put( "body", createBody( locale ) );
        model.put( "management", createFooter( locale ) );

        Mail mail = new Mail();
        mail.setFrom( emailFrom );
        mail.setTo( user.getEmail() );
        mail.setSubject( subject );
        mail.setModel( model );

        String templateName = "activationEmail.ftl";

        //TODO generate activation code;;
        // TODO save the code to database;;

        EmailResponse response = emailService.sendEmail( mail, templateName );
        return response;
    }


    private String prepareActivationLink() {

        String subdomain = "account/activation";
        String code = generateActivationCode();
        return domain + subdomain + "/" + code;
    }


    private String generateActivationCode() {

        return "somegeneratedcode";
    }


    private void saveActivationCode() {

        //code to update activation code;;
    }


    private String createFooter( Locale locale ) {

        String management = resourceBundleMessageSource.getMessage(
                "activationEmail.management", new Object[] {}, locale );
        return management;
    }


    private String createSubject( Locale locale ) {

        String subject = resourceBundleMessageSource.getMessage(
                "activationEmail.subject", new Object[] {}, locale );
        return subject;
    }


    private String createBody( Locale locale ) {

        String body = resourceBundleMessageSource.getMessage(
                "activationEmail.body", new Object[] {}, locale );
        String formattedBody = MessageFormat.format( body, "Cloud School" );
        return formattedBody;
    }


    private String createSalutation( Locale locale ) {

        return resourceBundleMessageSource.getMessage(
                "activationEmail.dear", new Object[] {}, locale );
    }

}
