package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name= "cart_item")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name= "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name= "product_id")
	private Products product;
	
	private int quantity;
}
