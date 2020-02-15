package com.guesthouse.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guesthouse.domain.user.User;
import com.guesthouse.helper.loggedinuser.LoggedInUserHelper;

@Service
public class LoggedInUserDetailServiceImpl implements LoggedInUserDetailService {

    @Autowired
    private LoggedInUserHelper loggedInUserHelper;

    @Override
    public LoggedInUserDetailInitialData getLoggedInUserDetails() {

        User user = loggedInUserHelper.getLoggedInUser();

        LoggedInUserDetailInitialData initialData = new LoggedInUserDetailInitialData(
                user.getFirstName(), user.getLastName(), user.getEmail() );

        return initialData;
    }

}
