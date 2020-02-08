package com.guesthouse.service.client.account.register;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guesthouse.domain.address.Address;
import com.guesthouse.domain.address.AddressType;
import com.guesthouse.domain.address.AddressTypeEnum;
import com.guesthouse.domain.address.County;
import com.guesthouse.domain.client.Client;
import com.guesthouse.domain.user.Role;
import com.guesthouse.domain.user.RoleEnum;
import com.guesthouse.domain.user.User;
import com.guesthouse.helper.county.CountyHelper;
import com.guesthouse.helper.county.CountyTransfer;
import com.guesthouse.repository.address.AddressRepository;
import com.guesthouse.repository.address.AddressTypeRepository;
import com.guesthouse.repository.address.CountyRepository;
import com.guesthouse.repository.client.ClientRepository;
import com.guesthouse.repository.user.RoleRepository;
import com.guesthouse.repository.user.UserRepository;
import com.guesthouse.shared.SaveResponse;

@Service
public class ClientRegistrationServiceImpl implements ClientRegistrationService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CountyRepository countyRepository;

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CountyHelper countyHelper;

    @Override
    public SaveResponse save( ClientRegistrationRequest request ) {

        if ( userRepository.findByEmail( request.getEmail() ).isPresent() ) {
            return new SaveResponse( false, "Email already exists." );
        }

        User savedUser = saveUser( request );

        Address address = saveAddress( request );
        Client client = new Client();
        client.setIdNumber( request.getIdNumber() );
        client.setPhone( request.getPhone() );
        client.setUser( savedUser );
        client.setAddress( address );
        clientRepository.save( client );

        return new SaveResponse( true, null );

    }


    private User saveUser( ClientRegistrationRequest request ) {

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
        return savedUser;
    }


    private Address saveAddress( ClientRegistrationRequest request ) {

        County county = countyRepository.findById( request.getCountyId() ).get();
        Long addressTypeId = AddressTypeEnum.CLIENT_TYPE.getId();
        AddressType addressType = addressTypeRepository.findById( addressTypeId ).get();

        Address address = new Address();
        address.setSubCountyName( request.getSubCountyName() );
        address.setTown( request.getTown() );
        address.setCounty( county );
        address.setAddressType( addressType );
        Address savedAddress = addressRepository.save( address );
        return savedAddress;
    }


    private Role getRole( Long id ) {

        Optional<Role> role = roleRepository.findById( id );
        return role.orElse( null );
    }


    @Override
    public ClientRegistrationInitialData getInitialData() {

        List<CountyTransfer> countyTransfers = countyHelper.createCountyTransfers();

        ClientRegistrationInitialData initialData = new ClientRegistrationInitialData(
                countyTransfers );

        return initialData;
    }
}
