package com.example.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloud.model.Coupon;
import com.example.springcloud.model.Product;
import com.example.springcloud.repos.ProductRepo;
import com.example.springcloud.restclients.CouponClient;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/productapi")
@RefreshScope
public class ProductRestController {

	@Autowired
	ProductRepo repo;
	
	@Autowired
	CouponClient couponClient;
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@Retry(name="product-api", fallbackMethod="handleError")
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
	}
	
	public Product handleError(Product product, Exception exception) {
		System.out.println("Inside Handle Error.");
		return product;		
	}
	
}
