package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityFilter {

    private AuthenticationProvider provider;
    private JwtFilterChain filter;

    @Bean
    public void SecurityFilterChain securityFilterChain (HttpSecurity http){
        return http
                    .cors(withDefaults())
                    .csrf()
                    .disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/auth/**")
                    .permitAll()
                    .requestMatchers("/addproduct/**")
                    .requestMatchers("/deleteproduct/**")
                    .requestMatchers("/addtocart/**")
                    .requestMatchers("/buyproduct/**")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .
    }
}
