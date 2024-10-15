package br.edu.dio.curso.spring.security.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.List;

public class JWTCreator {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String create(String prefix,String key, JWTObject jwtObject) {

        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
        String token = Jwts.builder()
                .subject(jwtObject.getSubject())
                .claims()
                        .issuedAt(jwtObject.getIssuedAt())
                        .expiration(jwtObject.getExpiration())
                        .add(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()))
                        .and()
                .signWith(secretKey, Jwts.SIG.HS512)
                .compact();

        return prefix + " " + token;

    }

    public static JWTObject create(String token,String prefix,String key) {

        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
        token = token.replace(prefix, "");
        token = Strings.trimAllWhitespace(token);
        Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
        JWTObject object = new JWTObject();
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        object.setRoles((List<String>) claims.get(ROLES_AUTHORITIES));
        return object;

    }

    private static List<String> checkRoles(List<String> roles) {
        return roles.stream().map(s -> "ROLE_" + s.replaceAll("ROLE_","")).toList();
    }

}