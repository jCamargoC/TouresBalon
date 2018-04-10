package com.touresbalon.common.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomEntryPoint customEntryPoint;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilter(authenticationFilter())
                .authorizeRequests()
                .antMatchers("/login", "/logout").permitAll()
                .antMatchers(HttpMethod.POST,"/client/").permitAll()
                .antMatchers("/**").access("hasAuthority('AUTH_USER')")
                .and()
                .httpBasic()
                .authenticationEntryPoint(customEntryPoint);
        http.logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID"); 
        http.csrf()
                .disable();
        http.cors();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
        UsernamePasswordAuthenticationFilter authenticationFilter = new UsernamePasswordAuthenticationFilter();
        authenticationFilter.setPostOnly(false);
        authenticationFilter.setAuthenticationSuccessHandler(customSuccessHandler());
        authenticationFilter.setAuthenticationManager(authenticationManager());
        return authenticationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManager authenticationManager = new ProviderManager(authenticator());
        return authenticationManager;
    }

    @Bean
    public List<AuthenticationProvider> authenticator() {
        List<AuthenticationProvider> customAuthenticationProviders = new ArrayList<AuthenticationProvider>();
        customAuthenticationProviders.add(customAuthenticationProvider);
        return customAuthenticationProviders;
    }

    @Bean
    public CustomSuccessHandler customSuccessHandler() {
        CustomSuccessHandler customSuccessHandler = new CustomSuccessHandler();
        return customSuccessHandler;
    }
    
}
