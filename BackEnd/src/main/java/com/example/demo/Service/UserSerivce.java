package com.example.demo.Service;

import java.util.Optional;

import static org.apache.tomcat.jni.SSLConf.check;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSerivce {
    
    private final UserRepository repository;
    private final JwtService service;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager manager;

    public boolean signUp(User user) {
        var users = User.builder()
                                .name(user.getName())
                                .username(user.getUsername())
                                .password(passwordEncoder.encode(user.getPassword()))
                                .build();
        Optional<User> check = repository.findUserByUsername(user.getUsername());
        if(check.isPresent()){
            throw new IllegalStateException ("Email is already used!");
        }
        repository.save(users);
        return true;
    }
}
