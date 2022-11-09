package com.ll.ebook.app.security.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.crypto.SecretKey;
import java.util.Base64;

public class JwtConfig {
    @Value("${custom.jwt.secretKey}")
    private String secretKeyPlain;

    @Bean
    public SecretKey jwtSecretKey() {
        String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKeyPlain.getBytes());
        return Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());
    }
}
