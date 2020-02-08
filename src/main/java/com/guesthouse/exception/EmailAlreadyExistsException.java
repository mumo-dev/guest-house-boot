package com.guesthouse.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = -5753732694934800227L;

    public EmailAlreadyExistsException( String message ) {

        super( message );
    }

}
