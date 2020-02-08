package com.guesthouse.shared;

public class SaveResponse {

    private boolean saved;

    public SaveResponse( boolean saved ) {

        this.saved = saved;
    }


    public boolean isSaved() {

        return saved;
    }


    public void setSaved( boolean saved ) {

        this.saved = saved;
    }

}
