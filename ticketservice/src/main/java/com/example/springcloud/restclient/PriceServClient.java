package com.example.springcloud.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="PRICING", url="http://localhost:9090")
public interface PriceServClient {
	
	@RequestMapping(method=RequestMethod.GET, path="/price/{id}")
	public int determinePrice(@PathVariable("id") int id);
}
