package com.prince.bookstoreapi;

import com.prince.bookstoreapi.config.SecurityUtility;
import com.prince.bookstoreapi.domain.User;
import com.prince.bookstoreapi.domain.security.Role;
import com.prince.bookstoreapi.domain.security.UserRole;
import com.prince.bookstoreapi.service.RoleService;
import com.prince.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreApiApplication implements CommandLineRunner {

    private RoleService roleService;
    private UserService userService;

    @Autowired
    public BookstoreApiApplication(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        /*Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");

        role1 = roleService.createRole(role1);

        Role role2 = new Role();
        role2.setRoleId(0);
        role2.setName("ROLE_ADMIN");

        role2 = roleService.createRole(role2);

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Adams");
        user1.setUsername("j");
        user1.setPassword("{bcrypt}"+SecurityUtility.passwordEncoder().encode("p"));
        user1.setEmail("JAdams@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();

        userRoles.add(new UserRole(user1, role1));

        user1.getUserRoles().addAll(userRoles);

        userService.createUser(user1);

        userRoles.clear();

        User user2 = new User();
        user2.setFirstName("Admin");
        user2.setLastName("Admin");
        user2.setUsername("admin");
        user2.setPassword("{bcrypt}"+SecurityUtility.passwordEncoder().encode("p"));
        user2.setEmail("Admin@gmail.com");

        userRoles.add(new UserRole(user2, role2));

        user2.getUserRoles().addAll(userRoles);

        userService.createUser(user2);*/
    }
}
