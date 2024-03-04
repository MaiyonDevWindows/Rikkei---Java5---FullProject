package com.maiyon.security.jwt;

import com.maiyon.security.userPrincipal.UserPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class JwtProvider {
    @Value("${expired.time}")
    private Long EXPIRED;
    @Value("${secret.key}")
    private String SECRET_KEY;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<String> convertAuthoritiesToRoles(Collection<? extends GrantedAuthority> authorities) {
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority()); // Lấy ra tên của quyền (role)
        }
        return roles;
    }
    public String generateToken(UserPrincipal userPrincipal){
        Long userId = userPrincipal.getUser().getUserId();
        String username = userPrincipal.getUsername();
        List<String> roles = convertAuthoritiesToRoles(userPrincipal.getAuthorities());
        return Jwts.builder()
            .setSubject(String.valueOf(userId))
            .claim("username", username)
            .claim("roles", roles)
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + EXPIRED))
            .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
            .compact();
    }

    public Boolean validate(String token){
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expiredJwtException){
            logger.error("Expired Token {}",expiredJwtException.getMessage());
        } catch (SignatureException signatureException){
            logger.error("Invalid Signature Token {}",signatureException.getMessage());
        } catch (MalformedJwtException malformedJwtException){
            logger.error("Invalid format {}",malformedJwtException.getMessage());
        }
        return false;
    }

    public String getUserIdFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
    public String getUsernameFromToken(String token){
        return (String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("username");
    }
    public List<String> getRolesListFromToken(String token){
        return (List<String>) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("roles");
    }
}
