package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "products")
public class Products {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id; 
	
	@NotNull
	private String image;
	
	@NotNull
	private String name;
	
	@NotNull
	private String item;
	
	@NotNull
	@Size(min=50, max=100)
	private String description;
	
	@NotNull
	private int price;
}
