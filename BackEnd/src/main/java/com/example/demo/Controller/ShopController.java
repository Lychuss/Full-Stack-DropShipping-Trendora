package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Shops;
import com.example.demo.Service.UserSerivce;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path= "/api/trendora/shops")
@RequiredArgsConstructor
public class ShopController {

	private final UserSerivce service;
	
	@GetMapping
	public ResponseEntity<List<Shops>> getShops(){
		return ResponseEntity.ok(service.getShops());
	}
}
