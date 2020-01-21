package com.guesthouse.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.guesthouse.domain.AbstractPersistentEntity;

@Entity
@Table( name = "counties" )
public class County extends AbstractPersistentEntity {

    private static final long serialVersionUID = -5820265142668782858L;

    @Column( name = "name", nullable = false, length = 100 )
    private String name;

    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }

}
