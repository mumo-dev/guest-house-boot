package com.guesthouse.helper.loggedinuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.guesthouse.domain.user.User;
import com.guesthouse.repository.user.UserRepository;

@Component
public class LoggedInUserHelperImpl implements LoggedInUserHelper {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getLoggedInUser() {

        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if ( authentication == null ) {

            return null;
        }

        String email = authentication.getName();
        User user = userRepository.findByEmail( email ).orElse( null );
        return user;
    }

}
