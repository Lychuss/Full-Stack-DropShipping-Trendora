package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserSerivce;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path= "/api/trendora/auth")
public class SignUpController {

	private final UserSerivce service;
	
	@PostMapping("/signup")
	public ResponseEntity<Void> signUp(@Valid @RequestBody User user) {
		if(service.signUp(user)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
