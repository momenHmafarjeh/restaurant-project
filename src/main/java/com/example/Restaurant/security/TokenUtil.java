package com.example.Restaurant.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    private final String claim_subject = "sub";
    private final String claim_created = "created";

    @Value("${auth:secret}")
    private String secret;

    @Value("${auth:authHead}")
    private String authHead;

    public TokenUtil() {
    }

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
                .signWith(SignatureAlgorithm.ES512, authHead)
                .compact();

    }


    public String getNameToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            return claims.getSubject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}

