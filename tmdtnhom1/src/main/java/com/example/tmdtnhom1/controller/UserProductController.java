package com.example.tmdtnhom1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmdtnhom1.service.UserProductService;

/**
 * members must identify parameters, output response in order to use.
 * 
 * @author MyPC
 *
 */
@RestController
@RequestMapping("/userproductapi")
public class UserProductController {
	@Autowired
	UserProductService userProductService;

	@GetMapping("/historyBoughtProduct")
	public void historyBoughtProduct() {

	}
	// api: /available product
	public void getAvailableProduct() {
		
	}
	
	// phu
	// api: /orderProduct
	public void orderProduct() {
		userProductService.orderProduct();
	}

	// phu
	// api: /payment
	public void paymentOnline() {

	}

	// phu
	// api: /convertScoreToPromotion
	public void convertScoreToPromotion() {

	}

}
