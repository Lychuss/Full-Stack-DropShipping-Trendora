package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityFilter {

    private AuthenticationProvider provider;
    private JwtFilterChain filter;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
                .cors(withDefaults())
                .csrf(csrf -> csrf
                        .disable())
                .authorizeHttpRequests(requests -> {
                    try {
                        requests
                        .requestMatchers("/auth/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .sessionManagement(management -> management
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(provider)
                                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return http.build();
    }
}
