package com.example.tmdtnhom1.service;

import org.springframework.stereotype.Service;

@Service
public class UserProductService {

	public void orderProduct() {
		/**
		 * if ( user uses convert Score to promotion ) { reduce money when order }
		 */
		autoIncreseScoreWhenBuyProduct();
		paymentOnline();
	}

	public void paymentOnline() {

	}

	public void autoIncreseScoreWhenBuyProduct() {

	}
}
