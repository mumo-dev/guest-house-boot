package com.guesthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guesthouse.service.user.LoggedInUserDetailInitialData;
import com.guesthouse.service.user.LoggedInUserDetailService;

@RestController
@RequestMapping( "/guesthouse/user" )
public class UserController {

    @Autowired
    private LoggedInUserDetailService loggedInUserDetailService;

    @RequestMapping( value = "/loggedinuserdetails/get",
            method = RequestMethod.POST )
    public ResponseEntity<LoggedInUserDetailInitialData> getLoggedInUserDetails() {

        LoggedInUserDetailInitialData loggedInDetails = loggedInUserDetailService
                .getLoggedInUserDetails();

        return ResponseEntity.status( HttpStatus.OK ).body( loggedInDetails );
    }

}
