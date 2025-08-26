package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Shops;

@Repository
public interface ShopsRepository extends JpaRepository<Shops, Integer>{

}
