package com.example.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloud.model.Price;
import com.example.springcloud.repos.PriceRepo;

@RestController
@RequestMapping("/priceapi")
public class PriceController {

	@Autowired
	PriceRepo repo;
	
	@RequestMapping(value="/prices", method = RequestMethod.POST)
	public Price postTicketPrice(@RequestBody Price price) {
		return repo.save(price);
	}
	
	@RequestMapping(value="/price/{id}", method = RequestMethod.GET)
	public int getTicketPrice(@PathVariable("id") int id) {
		return repo.findById(id);
	}
}
