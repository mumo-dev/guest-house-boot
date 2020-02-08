package com.guesthouse.service.client.account.register;

import com.guesthouse.shared.SaveResponse;

public interface ClientRegistrationService {

    ClientRegistrationInitialData getInitialData();

    SaveResponse save( ClientRegistrationRequest request );
}
