package xyz.victorl.scrontchback.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET_KEY = "mySecret1234"; // Make sure to use a secure key

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String generateAccessToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 15 * 60 * 1000)) // 15 minutes
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String generateRefreshToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 7 days
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String extractUsernameFromToken(String token) {
        try {
            // Initialize JWT verifier with the secret key
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();

            // Decode the JWT token
            DecodedJWT decodedJWT = verifier.verify(token);

            // Extract the subject from the token
            return decodedJWT.getSubject();
        } catch (Exception e) {
            // Handle exceptions such as token expiration or invalid token
            return null;
        }
    }
}
