package com.guesthouse.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.guesthouse.domain.AbstractPersistentEntity;

@Entity
@Table( name = "users" )
public class User extends AbstractPersistentEntity {

    private static final long serialVersionUID = 109877777777777774L;

    @Column( nullable = false, name = "first_name", length = 100 )
    private String firstName;

    @Column( nullable = false, name = "last_name", length = 100 )
    private String lastName;

    @Column( nullable = false, unique = true, length = 100 )
    private String email;

    @Column( nullable = false )
    private String password;

    @Column( name = "active" )
    private boolean active = false;

    @ManyToMany( cascade = CascadeType.MERGE )
    private List<Role> roles = new ArrayList<>();

    public void addRole( Role role ) {

        roles.add( role );
    }


    public User() {

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


    public boolean isActive() {

        return active;
    }


    public void setActive( boolean active ) {

        this.active = active;
    }


    public List<Role> getRoles() {

        return roles;
    }


    public void setRoles( List<Role> roles ) {

        this.roles = roles;
    }

}
