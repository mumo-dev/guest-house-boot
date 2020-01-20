package com.guesthouse.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guesthouse.domain.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
