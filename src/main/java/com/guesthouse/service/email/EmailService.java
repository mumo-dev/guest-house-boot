package com.guesthouse.service.email;

public interface EmailService {

    EmailResponse sendEmail( Mail mail, String templateName );
}
