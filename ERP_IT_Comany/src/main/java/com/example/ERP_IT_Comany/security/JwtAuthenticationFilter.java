package com.example.ERP_IT_Comany.security;

import com.auth0.jwt.JWT;
import com.example.ERP_IT_Comany.entity.LoginViewModel;
import com.example.ERP_IT_Comany.repository.EmployerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                   EmployerRepository employerRepository) {
        this.authenticationManager = authenticationManager;
    }

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 10000)
    @PostMapping("/login")
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        LoginViewModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>()
        );

        response.setHeader("Access-Control-Expose-Headers", "Origin, X-Requested-With, " +
                "Content-Type, Accept, Accept-Encoding, Accept-Language, Host," +
                "Referer, Connection, User-Agent, Authorization, sw-useragent, sw-version");

        //Authenticate user
        try {
            return authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            try {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Wrong password");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (NullPointerException e) {
            try {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Wrong userName");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (InternalAuthenticationServiceException e) {
            try {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "NonUnique userName");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (AccountStatusException e) {
            try {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Locked");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        //Create Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));

        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);

    }
}
