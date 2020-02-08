package com.guesthouse.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guesthouse.service.client.account.register.ClientRegistrationInitialData;
import com.guesthouse.service.client.account.register.ClientRegistrationRequest;
import com.guesthouse.service.client.account.register.ClientRegistrationService;
import com.guesthouse.shared.SaveResponse;

@RestController
@RequestMapping( "/guesthouse/api/client" )
public class ClientRegistrationController {

    @Autowired
    private ClientRegistrationService clientRegistrationService;

    @GetMapping( "/register/initialdata" )
    public ResponseEntity<ClientRegistrationInitialData> getInitialData() {

        ClientRegistrationInitialData initialData = clientRegistrationService
                .getInitialData();
        return ResponseEntity.ok( initialData );
    }


    @PostMapping( "/register/save" )
    public ResponseEntity<SaveResponse> registerUser(
            @RequestBody ClientRegistrationRequest request ) {

        SaveResponse response = clientRegistrationService.save( request );
        return ResponseEntity.status( HttpStatus.CREATED ).body( response );
    }

}
