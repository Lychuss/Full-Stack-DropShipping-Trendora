package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Model.User;
import com.example.demo.Service.UserSerivce;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
class DemoApplicationTests {

	private User user;

	@Autowired
	private UserSerivce service;

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
}
