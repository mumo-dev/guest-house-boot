package com.guesthouse.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
@JsonIgnoreProperties(
        value = { "createdBy", "modifiedBy" },
        allowGetters = true )

public abstract class AuditModel implements Serializable {
    //
    //    @Temporal( TemporalType.TIMESTAMP )
    //    @Column( name = "created_at", nullable = false, updatable = false )
    //    @CreatedDate
    //    private Date createdAt;
    //
    //    @Temporal( TemporalType.TIMESTAMP )
    //    @Column( name = "updated_at", nullable = false )
    //    @LastModifiedDate
    //    private Date updatedAt;

    private static final long serialVersionUID = 10L;

    @Column( name = "created_by" )
    @CreatedBy
    private String createdBy;

    @Column( name = "modified_by" )
    @LastModifiedBy
    private String modifiedBy;

    public String getCreatedBy() {

        return createdBy;
    }


    public void setCreatedBy( String createdBy ) {

        this.createdBy = createdBy;
    }


    public String getModifiedBy() {

        return modifiedBy;
    }


    public void setModifiedBy( String modifiedBy ) {

        this.modifiedBy = modifiedBy;
    }
}
