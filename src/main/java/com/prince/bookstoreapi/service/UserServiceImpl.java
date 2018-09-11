package com.prince.bookstoreapi.service;

import com.prince.bookstoreapi.domain.User;
import com.prince.bookstoreapi.domain.security.UserRole;
import com.prince.bookstoreapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User createUser(User user) throws Exception{
        User localUser = userRepository.findByUsername(user.getUsername());
        if(localUser != null) {
            logger.info("User with username {} already exists", user.getUsername());
            throw new Exception("Username "+user.getUsername()+" already in use. Try another one.");
        }

        localUser = userRepository.save(user);
        return localUser;
    }
}
