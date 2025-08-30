package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	@JoinColumn(name= "cart_item")
	List<CartItem> cartItem;
}
