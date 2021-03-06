package com.example.springcloud.restclients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springcloud.model.Coupon;

@FeignClient("GATEWAY-SERVICE")
@RibbonClient("GATEWAY-SERVICE")
public interface CouponClient {
	@GetMapping("/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
