package com.prince.bookstoreapi.service;

import com.prince.bookstoreapi.domain.User;
import com.prince.bookstoreapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Service
public class UserSecurityService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserSecurityService.class);

    private UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        System.out.println("Username: "+username);

        if(user == null){
            logger.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username: "+ username+ " not found");
        }

        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword().substring(user.getPassword().indexOf("}") + 1));
        builder.authorities(user.getAuthorities());

        return builder.build();
    }
}
