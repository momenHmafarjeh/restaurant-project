package com.example.Restaurant.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private final String claim_subject = "sub";
    private final String claim_created = "created";

    private Date expirationDate() {
        return new Date(System.currentTimeMillis() + 604800L);
    }

    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();
        claims.put(claim_subject, userDetails.getUsername());
        claims.put(claim_created, new Date());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate())
                .signWith(SignatureAlgorithm.ES512, "token1")
                .compact();

    }

}

