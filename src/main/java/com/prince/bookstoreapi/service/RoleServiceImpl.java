package com.prince.bookstoreapi.service;

import com.prince.bookstoreapi.domain.security.Role;
import com.prince.bookstoreapi.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public Role createRole(Role role) throws Exception {
        Role localRole = roleRepository.findByName(role.getName());
        if(localRole != null) {
            logger.info("Role {} already exists", role.getName());
            throw new Exception("Role "+role.getName()+" already in there to use.");
        }
        localRole = roleRepository.save(role);
        return localRole;
    }
}
