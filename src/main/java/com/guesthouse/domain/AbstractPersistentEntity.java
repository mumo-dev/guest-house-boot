package com.guesthouse.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class AbstractPersistentEntity implements Serializable {

    /**
     * Default version ID for serialization version management.
     */
    private static final long serialVersionUID = 1L;

    /**
     * You need to create a sequence in postgresql:
     *
     * CREATE SEQUENCE uweee_sequence START 10001;
     *
     * Starts at 10001 to allow for standing data. All standing data must have a
     * id of less than 10001 else duplicate key exceptions will occur
     */
    //    @Id
    //    @Column( name = "ID" )
    //    @SequenceGenerator( name = "identifier", sequenceName = "uweee_sequence",
    //            allocationSize = 1, initialValue = 10001 )
    //    @GeneratedValue( strategy = GenerationType.SEQUENCE,
    //            generator = "identifier" )
    //    @NotNull
    //    private Long id;

    // https://stackoverflow.com/questions/19665105/how-to-maintain-hibernate-id-sequence-with-mysql
    //    @Id
    //    @Column( name = "ID", columnDefinition="int unsigned" )
    //    @GeneratedValue(strategy=GenerationType.AUTO)
    //    @NotNull
    @Id
    @Column( name = "id", columnDefinition = "INT(10) UNSIGNED" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    // postgres
    // @Temporal( TemporalType.TIMESTAMP )
    // @Column( name = "created_timestamp", updatable = true, nullable = false,
    //          columnDefinition = "TIMESTAMP WITH TIME ZONE" )
    // private Calendar createdTimestamp;

    // mysql
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    @Column( name = "created_at",
            updatable = true, nullable = false,
            columnDefinition = "timestamp default current_timestamp" )
    private Calendar createdAt;

    // postgres
    // @Temporal( TemporalType.TIMESTAMP )
    // @Column( name = "updated_timestamp", updatable = true, nullable = false,
    //          columnDefinition = "TIMESTAMP WITH TIME ZONE" )
    // private Calendar updatedTimestamp;

    // mysql
    @Temporal( TemporalType.TIMESTAMP )
    @UpdateTimestamp
    @Column( name = "updated_at", updatable = true, nullable = false,
            columnDefinition = "timestamp default current_timestamp on update current_timestamp" )
    private Calendar updatedAt;

    public Long getId() {

        return this.id;
    }


    /**
     * Sets the primary key identifier.
     *
     * @param id
     *            Primary key identifier.
     */
    public void setId( Long id ) {

        this.id = id;
    }


    public Calendar getCreatedAt() {

        return createdAt;
    }


    public void setCreatedAt( Calendar createdAt ) {

        this.createdAt = createdAt;
    }


    public Calendar getUpdatedAt() {

        return updatedAt;
    }


    public void setUpdatedAt( Calendar updatedAt ) {

        this.updatedAt = updatedAt;
    }


    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
        return result;
    }


    @Override
    public boolean equals( Object obj ) {

        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        AbstractPersistentEntity other = ( AbstractPersistentEntity )obj;
        if ( id == null ) {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        return true;
    }


    @Override
    public String toString() {

        return "AbstractPersistentEntity [id=" + id + "]";
    }
}
