package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
class DemoApplicationTests {

	private final UserDetails user;

	@BeforeEach
	void builtIn(){
		var user = UserDetails
							.builder()
							.name("Raphael")
							.username("raphael2@gmail.com")
							.password("123");
	}

	@Test
	void contextLoads() {
	}

}
