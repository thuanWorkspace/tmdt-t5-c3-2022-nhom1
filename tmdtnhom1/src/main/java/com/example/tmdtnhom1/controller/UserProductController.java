package com.example.tmdtnhom1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * members must identify parameters, output response in order to use.
 * @author MyPC
 *
 */
@RestController
@RequestMapping("/userproductapi")
public class UserProductController {
	
	@GetMapping("/historyBoughtProduct")
	public void historyBoughtProduct() {
		
	}
	// api: /orderProduct
	public void orderProduct() {
		
	}
	// api: /payment
	public void paymentOnline() {
		
	}
	public void autoIncreseScoreWhenBuyProduct() {
		
	}
	//api: /convertScoreToPromotion
	public void convertScoreToPromotion() {
		
	}
	
}
