package com.touresbalon.common.security;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.touresbalon.common.service.CommonServiceContract;
import com.touresbalon.common.utils.EncryptionUtils;
import com.touresbalon.entities.clients.Client;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {    

    @Autowired
    CommonServiceContract<Client> userService;
    
    @Autowired            
    UserDetailsService userDetailsService;          

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        if (authorizedUser(userName, password)) {
            
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
            
            Collection<? extends GrantedAuthority> grantedAuths = userDetails.getAuthorities();
                    
                    
            Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuths);            
            return auth;
        } else {
            throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
        }
    }

    private boolean authorizedUser(String userName, String password) {        
        Client userDataLogin = userService.findByAttribute("email", userName);
        if (userDataLogin == null) {            
            return false;
        }
       
        if(!EncryptionUtils.checkPassword(password, userDataLogin.getPassword())) {
            return false;
        }            
        return true;
    }

    
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
