package com.guesthouse.service.client.account.register;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guesthouse.domain.client.Client;
import com.guesthouse.domain.user.Role;
import com.guesthouse.domain.user.RoleEnum;
import com.guesthouse.domain.user.User;
import com.guesthouse.repository.client.ClientRepository;
import com.guesthouse.repository.user.RoleRepository;
import com.guesthouse.repository.user.UserRepository;
import com.guesthouse.shared.SaveResponse;

@Service
public class ClientRegistrationServiceImpl implements ClientRegistrationService {

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ClientRepository clientRepository;

    public ClientRegistrationServiceImpl( PasswordEncoder encoder,
            UserRepository userRepository,
            RoleRepository roleRepository, ClientRepository clientRepository ) {

        this.encoder = encoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.clientRepository = clientRepository;

    }


    @Override
    public SaveResponse save( ClientRegistrationRequest request ) {

        if ( userRepository.findByEmail( request.getEmail() ).isPresent() ) {
            return new SaveResponse( false, "Email already exists." );
        }

        User user = new User();
        user.setActive( true );
        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        user.setEmail( request.getEmail() );
        user.setPassword( encoder.encode( request.getPassword() ) );
        Long roleId = RoleEnum.CLIENT.getId();
        Role role = getRole( roleId );
        user.addRole( role );
        User savedUser = userRepository.save( user );

        Client client = new Client();
        client.setIdNumber( request.getIdNumber() );
        client.setPhone( request.getPhone() );
        client.setUser( savedUser );
        clientRepository.save( client );

        return new SaveResponse( true, null );

    }


    private Role getRole( Long id ) {

        Optional<Role> role = roleRepository.findById( id );
        return role.orElse( null );
    }
}
