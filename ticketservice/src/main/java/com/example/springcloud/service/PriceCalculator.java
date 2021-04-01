package com.example.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springcloud.restclient.PriceServClient;

@Service
public class PriceCalculator {

	@Autowired
	private PriceServClient psc;
	
	public int calculatePrice(int id, int numberOfTickets) {
		return psc.determinePrice(id)*numberOfTickets;
	}

}
