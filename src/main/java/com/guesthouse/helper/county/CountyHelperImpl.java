package com.guesthouse.helper.county;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guesthouse.domain.address.County;
import com.guesthouse.repository.address.CountyRepository;

@Component
public class CountyHelperImpl implements CountyHelper {

    @Autowired
    private CountyRepository countyRepository;

    @Override
    public List<CountyTransfer> createCountyTransfers() {

        List<County> counties = countyRepository.findAll();
        List<CountyTransfer> countyTransfers = new ArrayList<>();

        for ( County county : counties ) {
            CountyTransfer countyTransfer = new CountyTransfer( county.getId(), county.getName() );
            countyTransfers.add( countyTransfer );
        }

        return countyTransfers;
    }

}
