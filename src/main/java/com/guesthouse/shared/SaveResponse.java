package com.guesthouse.shared;

public class SaveResponse {

    private boolean saved;
    private String message;


    public SaveResponse() {

    }


    public SaveResponse( boolean saved, String message ) {

        this.saved = saved;
        this.message = message;
    }


    public boolean isSaved() {

        return saved;
    }


    public void setSaved( boolean saved ) {

        this.saved = saved;
    }


    public String getMessage() {

        return message;
    }


    public void setMessage( String message ) {

        this.message = message;
    }

}
