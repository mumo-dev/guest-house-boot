package com.guesthouse.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6214400501820748375L;

    public ResourceNotFoundException( String message ) {

        super( message );
    }

}
