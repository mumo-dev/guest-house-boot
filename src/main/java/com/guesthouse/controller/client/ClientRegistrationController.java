package com.guesthouse.controller.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guesthouse.service.client.account.register.ClientRegistrationRequest;
import com.guesthouse.service.client.account.register.ClientRegistrationService;
import com.guesthouse.shared.SaveResponse;

@RestController
@RequestMapping( "/guesthouse/api/client" )
public class ClientRegistrationController {

    private final ClientRegistrationService clientRegistrationService;

    public ClientRegistrationController( ClientRegistrationService clientRegistrationService ) {

        this.clientRegistrationService = clientRegistrationService;
    }


    @PostMapping( "/register/save" )
    public ResponseEntity<SaveResponse> registerUser(
            @RequestBody ClientRegistrationRequest request ) {

        SaveResponse response = clientRegistrationService.save( request );
        return ResponseEntity.status( HttpStatus.CREATED ).body( response );
    }

}
