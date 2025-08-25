package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.TokenDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.UserSerivce;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path= "/api/trendora/auth/login")
public class LoginController {
	
	private final UserSerivce service;

	@PostMapping
	public ResponseEntity<TokenDTO> login(@RequestBody User user){
		return ResponseEntity.ok(service.login(user));
	}
	
}
