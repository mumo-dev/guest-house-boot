package com.guesthouse.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.guesthouse.domain.AbstractPersistentEntity;

@Entity
@Table( name = "roles" )
public class Role extends AbstractPersistentEntity {

    private static final long serialVersionUID = -8876551129681267144L;

    @Column( nullable = false, unique = true )
    private String name;

    @ManyToMany( mappedBy = "roles" )
    private List<User> users = new ArrayList<>();

    public Role() {

    }


    public Role( String name ) {

        this.name = name;
    }


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }


    public List<User> getUsers() {

        return users;
    }


    public void setUsers( List<User> users ) {

        this.users = users;
    }

}
