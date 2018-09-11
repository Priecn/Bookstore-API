package com.prince.bookstoreapi.service;

import com.prince.bookstoreapi.domain.User;


public interface UserService {
    User createUser(User user) throws Exception;
}
