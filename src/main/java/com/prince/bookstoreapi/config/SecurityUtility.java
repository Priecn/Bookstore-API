package com.prince.bookstoreapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class SecurityUtility {

    private static final String SALT = "secret";

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    @Bean
    public static String randomPassword() {
        String SALT_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();

        while(salt.length() < 18) {
            int index = (int) (random.nextFloat() * SALT_CHAR.length());
            salt.append(SALT_CHAR.charAt(index));
        }

        return salt.toString();
    }

}
