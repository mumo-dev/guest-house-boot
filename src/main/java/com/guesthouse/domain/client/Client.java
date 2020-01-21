package com.guesthouse.domain.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.guesthouse.domain.AbstractPersistentEntity;
import com.guesthouse.domain.address.Address;
import com.guesthouse.domain.user.User;

@Entity
@Table( name = "clients" )
public class Client extends AbstractPersistentEntity {

    private static final long serialVersionUID = 18989728277272L;

    @Column( name = "phone", nullable = false, length = 15 )
    private String phone;

    @Column( name = "id_number", nullable = false, length = 15 )
    private Integer idNumber;

    @ManyToOne( )
    @JoinColumn( name = "fk_user", nullable = false )
    private User user;

    @ManyToOne
    @JoinColumn( name = "fk_address", nullable = false )
    private Address address;

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


    public User getUser() {

        return user;
    }


    public void setUser( User user ) {

        this.user = user;
    }


    public Address getAddress() {

        return address;
    }


    public void setAddress( Address address ) {

        this.address = address;
    }

}
