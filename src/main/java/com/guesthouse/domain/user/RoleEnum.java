package com.guesthouse.domain.user;

public enum RoleEnum {

    ADMIN( 1L, "ADMIN" ),
    CLIENT( 2L, "CLIENT" ),
    CUSTOMER( 3L, "CUSTOMER" );

    private RoleEnum( Long id, String name ) {

        this.id = id;
        this.name = name;
    }

    private Long id;
    private String name;

    public Long getId() {

        return id;
    }


    public void setId( Long id ) {

        this.id = id;
    }


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }

}
