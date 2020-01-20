package com.guesthouse.service.client.account.register;

import com.guesthouse.shared.SaveResponse;

public interface ClientRegistrationService {

    SaveResponse save( ClientRegistrationRequest request );
}
