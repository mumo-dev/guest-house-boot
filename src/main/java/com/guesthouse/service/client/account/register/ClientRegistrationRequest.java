package com.guesthouse.service.client.account.register;

public class ClientRegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer idNumber;

    public ClientRegistrationRequest() {

    }


    public String getFirstName() {

        return firstName;
    }


    public void setFirstName( String firstName ) {

        this.firstName = firstName;
    }


    public String getLastName() {

        return lastName;
    }


    public void setLastName( String lastName ) {

        this.lastName = lastName;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail( String email ) {

        this.email = email;
    }


    public String getPassword() {

        return password;
    }


    public void setPassword( String password ) {

        this.password = password;
    }


    public String getPhone() {

        return phone;
    }


    public void setPhone( String phone ) {

        this.phone = phone;
    }


    public Integer getIdNumber() {

        return idNumber;
    }


    public void setIdNumber( Integer idNumber ) {

        this.idNumber = idNumber;
    }

}
