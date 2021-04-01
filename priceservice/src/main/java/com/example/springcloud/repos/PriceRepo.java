package com.example.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springcloud.model.Price;

public interface PriceRepo extends JpaRepository<Price, Long>{

	int findById(int id);
	
}
