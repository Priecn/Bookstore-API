package com.prince.bookstoreapi.service;

import com.prince.bookstoreapi.domain.security.Role;


public interface RoleService {
    Role createRole(Role role) throws Exception;
}
