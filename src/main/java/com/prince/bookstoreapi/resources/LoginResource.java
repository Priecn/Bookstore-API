package com.prince.bookstoreapi.resources;

import com.prince.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginResource {

    private UserService userService;

    @Autowired
    public LoginResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/token")
    public Map<String, String> login(HttpSession httpSession, HttpServletRequest request) {

        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();

        System.out.println(remoteHost+":"+portNumber);
        System.out.println(request.getRemoteAddr());

        return Collections.singletonMap("token", httpSession.getId());
    }

    @GetMapping("/checksession")
    public ResponseEntity checkSession() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpSession session) {
        SecurityContextHolder.clearContext();
        session.invalidate();
        return new ResponseEntity(HttpStatus.OK);
    }
}
