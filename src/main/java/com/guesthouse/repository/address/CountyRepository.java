package com.guesthouse.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guesthouse.domain.address.County;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {

}
