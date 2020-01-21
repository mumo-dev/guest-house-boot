package com.guesthouse.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guesthouse.domain.address.AddressType;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {

}
