package com.prince.bookstoreapi.repository;

import com.prince.bookstoreapi.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String roleName);
}
