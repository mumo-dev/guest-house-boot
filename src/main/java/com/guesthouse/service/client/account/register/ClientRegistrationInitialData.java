package com.guesthouse.service.client.account.register;

import java.util.List;

import com.guesthouse.helper.county.CountyTransfer;

public class ClientRegistrationInitialData {

    private List<CountyTransfer> countyTransfers;

    public ClientRegistrationInitialData( List<CountyTransfer> countyTransfers ) {

        super();
        this.countyTransfers = countyTransfers;
    }


    public List<CountyTransfer> getCountyTransfers() {

        return countyTransfers;
    }


    public void setCountyTransfers( List<CountyTransfer> countyTransfers ) {

        this.countyTransfers = countyTransfers;
    }

}
