package com.guesthouse.service.email;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    private Configuration configuration;

    private FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean;


    public EmailServiceImpl(
            FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean ) {

        this.freeMarkerConfigurationFactoryBean =
                freeMarkerConfigurationFactoryBean;
        try {
            this.configuration = this.freeMarkerConfigurationFactoryBean
                    .createConfiguration();
        }
        catch ( IOException | TemplateException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @Override
    public EmailResponse sendEmail( Mail mail, String templateName ) {

        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper( mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name() );

            helper.addInline( "logo.jpeg", new ClassPathResource(
                    "assets/logo.jpeg" ) );

            Template t = configuration.getTemplate( templateName );

            String html = FreeMarkerTemplateUtils.processTemplateIntoString( t,
                    mail.getModel() );

            helper.setTo( mail.getTo() );
            helper.setFrom( mail.getFrom() );
            helper.setSubject( mail.getSubject() );
            helper.setText( html, true );

            emailSender.send( mimeMessage );

            return new EmailResponse( true, "Activation Email has been sent" );

        }
        catch ( MessagingException | IOException | TemplateException ex ) {
            // throw new RuntimeException( ex.getMessage(), ex );
            ex.printStackTrace();
            return new EmailResponse( false, ex.getMessage() );
        }

    }

}
