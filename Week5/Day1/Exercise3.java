package com.example.exercise3;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise3 {

    // Secret Key
    private static final String SECRET = "MY_SECRET_KEY";

    public static void main(String[] args) {

        SpringApplication.run(Exercise3.class, args);

        JwtTokenProvider provider = new JwtTokenProvider();

        String token = provider.createToken("Arjoo");

        System.out.println("Generated JWT Token:");
        System.out.println(token);
    }

    // JWT Provider
    static class JwtTokenProvider {

        public String createToken(String username) {

            Claims claims = Jwts.claims().setSubject(username);

            Date now = new Date();

            Date validity = new Date(now.getTime() + 3600000);

            return Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(now)
                    .setExpiration(validity)
                    .signWith(SignatureAlgorithm.HS256, SECRET)
                    .compact();
        }
    }
}

/*
==================== pom.xml ====================

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>

================ application.yml ================

spring:
  security:
    jwt:
      secret: MY_SECRET_KEY

*/