package com.example.tmdtnhom1.controller;

import com.example.tmdtnhom1.Utils.DateUtils;
import com.example.tmdtnhom1.model.UserProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tmdtnhom1.service.UserProductService;

import java.util.ArrayList;
import java.util.List;

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

	// phu
	@GetMapping("/historyBoughtProduct/{id_user}")
	public ResponseEntity<List<UserProduct>> historyBoughtProduct(@PathVariable("id_user") String id_user) {
		try {
			List<UserProduct> list = new ArrayList<>();
			userProductService.getUserProductByUser(id_user).forEach(list::add);

			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// api: /availableProduct
	public void getAvailableProduct() {

	}

	// api: /available product
	@GetMapping("/AvailableProduct/{id_user}")
	public ResponseEntity<List<UserProduct>> getAvailableProduct(@PathVariable("id_user") String id_user) {
		try {
			List<UserProduct> list = new ArrayList<>();
			userProductService.getAvailableProduct(id_user).forEach(list::add);

			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// phu
	// api: /orderProduct
	// nguoi dung chon mua bang tien hoac diem thuong
	@PostMapping("/orderProduct") // requestbody chi gui len userid va productid
	public ResponseEntity<UserProduct> orderProduct(@RequestBody UserProduct userProduct) {
		try {
			UserProduct user_Product = userProductService.orderProduct(
					new UserProduct(userProduct.getId_user(), userProduct.getId_product(), DateUtils.currentDate()));
			if (user_Product != null) {
				return new ResponseEntity<UserProduct>(user_Product, HttpStatus.OK);
			}

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * số điểm sẽ tương ứng với tiền để mua sản phảm theo tỷ lệ người dùng có thể
	 * chọn mua bằng điểm nếu đủ số điểm tương ứng với giá tiền của sản phẩm
	 **/
	@PostMapping("/orderScoreProduct") // requestbody chi gui len userid va productid
	public ResponseEntity<UserProduct> orderScoreProduct(@RequestBody UserProduct userProduct) {
		try {
			UserProduct user_Product = new UserProduct(userProduct.getId_user(), userProduct.getId_product(),
					DateUtils.currentDate());
			System.out.println(user_Product.getId_user() + "- id -" + user_Product.getId_product());
			if (userProductService.checkOrderProductbyScore(user_Product)) {
				System.out.println("before order");
				user_Product = userProductService.orderProductbyScore(user_Product);
				System.out.println("after order");
				if (user_Product != null) {
					return new ResponseEntity<UserProduct>(user_Product, HttpStatus.OK);
				}
			}

			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
