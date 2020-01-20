package com.guesthouse.service.email;

public class EmailResponse {

    private String message;
    private boolean sent;


    public EmailResponse( boolean sent, String message ) {

        this.sent = sent;
        this.message = message;
    }


    public EmailResponse() {

    }


    public String getMessage() {

        return message;
    }


    public void setMessage( String message ) {

        this.message = message;
    }


    public boolean isSent() {

        return sent;
    }


    public void setSent( boolean sent ) {

        this.sent = sent;
    }

}
