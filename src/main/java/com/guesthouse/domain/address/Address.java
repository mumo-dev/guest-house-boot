package com.guesthouse.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.guesthouse.domain.AbstractPersistentEntity;

@Entity
@Table( name = "addresses" )
public class Address extends AbstractPersistentEntity {

    private static final long serialVersionUID = 2064166903133444156L;

    @Column( name = "sub_county_name", nullable = false, length = 100 )
    private String subCountyName;

    @Column( name = "town", nullable = false, length = 100 )
    private String town;

    @ManyToOne
    @JoinColumn( name = "fk_address_type", nullable = false )
    private AddressType addressType;

    @ManyToOne
    @JoinColumn( name = "fk_county", nullable = false )
    private County county;

    public String getSubCountyName() {

        return subCountyName;
    }


    public void setSubCountyName( String subCountyName ) {

        this.subCountyName = subCountyName;
    }


    public String getTown() {

        return town;
    }


    public void setTown( String town ) {

        this.town = town;
    }


    public AddressType getAddressType() {

        return addressType;
    }


    public void setAddressType( AddressType addressType ) {

        this.addressType = addressType;
    }


    public County getCounty() {

        return county;
    }


    public void setCounty( County county ) {

        this.county = county;
    }

}
