package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Model.TokenDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.JwtService;
import com.example.demo.Service.UserSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
class DemoApplicationTests {

	private User user;

	private UserDetails userLogin;

	@Autowired
	private UserSerivce service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder encoder;

	@BeforeEach
	void builtIn(){
		user = User
							.builder()
							.name("raphael")
							.username("raphael2@gmail.com")
							.password("123")
							.build();
	}

	@Test
	void testSignUp() {
		assertTrue(service.signUp(user));
	}

	@Test
	void testLogin() {
		TokenDTO token = service.login(user);
		log.info(token.getToken());
		String username = jwtService.extractUsername(token.getToken());
		assertTrue(username.equals(user.getUsername()));
	}
}
