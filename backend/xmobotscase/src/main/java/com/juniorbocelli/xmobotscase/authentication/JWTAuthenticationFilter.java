package com.juniorbocelli.xmobotscase.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juniorbocelli.xmobotscase.core.security.config.SecurityConstants;
import com.juniorbocelli.xmobotscase.user.data.datasources.impl.UserDatasourcesLocalImpl;
import com.juniorbocelli.xmobotscase.user.data.models.UserModel;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;
    public UserDatasourcesLocalImpl userDatasourcesLocalImpl;

    public JWTAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager,
            UserDatasourcesLocalImpl userDatasourcesLocalImpl) {
        super(customAuthenticationManager);
        this.customAuthenticationManager = customAuthenticationManager;
        this.userDatasourcesLocalImpl = userDatasourcesLocalImpl;
        setFilterProcessesUrl(SecurityConstants.LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
            HttpServletResponse res) throws AuthenticationException {
        try {
            UserModel creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserModel.class);

            return customAuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain,
            Authentication auth) throws IOException {
        String token = JWT.create()
                .withSubject(auth.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

        UserModel userModel = this.userDatasourcesLocalImpl.findByUsername(auth.getName());

        String body = "{\"id\": " + userModel.getId() + ", \"name\": " + "\"" + userModel.getName() + "\""
                + ", \"email\": " + "\"" + userModel.getEmail()
                + "\""
                + ", \"password\": " + "\"" + userModel.getPassword() + "\"" + ", \"token\": " + "\"" + token + "\""
                + "}";

        res.getWriter().write(body);
        res.getWriter().flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        try {
            String body = failed.getMessage();

            response.setHeader("Content-Type", "application/json;charset=utf-8");
            response.getWriter().print("{\"message\":" + "\"" + body + "\"}");
            response.setStatus(401);
            response.getWriter().flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
