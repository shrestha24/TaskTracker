package com.example.tasktracker.service.implementation;

import com.example.tasktracker.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImplentation implements JWTService {

    private String generateToken(UserDetails userDetails){
        return Jwts.builder().subject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public String extractUerName(String token){
        return  extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolvers){
        final Claims claims = extractClaims(token);
        return claimResolvers.apply(claims);
    }

    private Key getSignKey(){
        byte[] key = Decoders.BASE64.decode("SOURAVPAGALHAI134233564376865745632452423");
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractClaims(String token){
        return Jwts.parser().setSigningKey(getSignKey()).build().parseSignedClaims(token).getBody();
    }

    public boolean isTokenValid(String token,  UserDetails userDetails){
        final String username = extractUerName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
