package com.cg.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cg.service.CustomUserDetailsService;
import com.cg.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * @author Aditya Ghogale
 *
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

	//reference of JwtUtil class
    @Autowired
    private JwtUtil jwtUtil;
    
    //reference of custom user details service
    @Autowired
    private CustomUserDetailsService service;


    //this method extracts token form body
    //validates token
    //If token is valid and every other info. is also valid
    //this methods then allows to browse to other url
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    	//this will fetch authorization value from body which contains token with authorization type
        String authorizationHeader = httpServletRequest.getHeader("Authorization");

        //to store token value
        String token = null;
        
        //to store username
        String userName = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // to extract token only from 
        	//Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZGkiLCJleHAiOjE2MDQyNzI0MDAsImlhdCI6MTYwNDIzNjQwMH0.N5nsos7rdeElTHScIBfh75viX0PrlO6Qp2tMCx5fBro
        	
        	token = authorizationHeader.substring(7);
            userName = jwtUtil.extractUsername(token);
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = service.loadUserByUsername(userName);

            //here we validate token to see if token is expired or not and check password
            //here we are checking if token is valid, if valid
            //then we check user details if they are valid or not if valid then
            //setting its value to security context 
            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        
        //this method will filter 
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
