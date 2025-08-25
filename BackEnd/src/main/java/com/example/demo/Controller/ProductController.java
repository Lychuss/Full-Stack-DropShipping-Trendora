package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Products;
import com.example.demo.Service.UserSerivce;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path= "/api/trendora/products")
@RequiredArgsConstructor
public class ProductController {

	private final UserSerivce service;
	
	@GetMapping
	public ResponseEntity<List<Products>> getProducts(){
		return ResponseEntity.ok(service.getProducts());
	}
	
}
