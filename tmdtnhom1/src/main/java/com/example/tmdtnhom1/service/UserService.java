package com.example.tmdtnhom1.service;

import java.util.List;
import java.util.Optional;

import com.example.tmdtnhom1.model.Product;
import com.example.tmdtnhom1.model.UserProduct;
import com.example.tmdtnhom1.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	UserProductService userProductService;
	@Autowired
	ProductService productService;
	//admin
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	//user
	//login by email only.
	public void login(String email,String password) {
		
	}
	public void register() {
		
	}
	public void googleLogin() {
		
	}
	public void facebookLogin() {
		
	}
	public void logOut() {
		
	}
	//forgot password
	public void resetPassword() {
		
	}
	public void changePassword() {
		
	}

	//phu
	//update userInfo
	public User save(User user){
		return userRepository.save(user);
	}

	public Optional<User> findById(String id) {
		return  userRepository.findById(id);
	}

	//User download File
	public UserType getType(User user) {
		//define type of user

		List<UserProduct> availablelist = userProductService.getAvailableProduct(user.getId());

		for (UserProduct sp : availablelist){
			Product product = productService.getById(sp.getId_product()).get();
			if (UserType.VIP.equalsName(product.getProduct_name())){
				return UserType.VIP;
			}
		}

		for (UserProduct sp : availablelist){
			Product product = productService.getById(sp.getId_product()).get();
			if (UserType.STORAGE.equalsName(product.getProduct_name())){
				return UserType.STORAGE;
			}
		}
		return UserType.NORMAL;
	}

	public double getLimitData(User user){
		double limitdata = 0;

		for (UserProduct sp : userProductService.getAvailableProduct(user.getId())){

			Product product = productService.getById(sp.getId_product()).get();
			limitdata += product.getTransfer();
		}
		return limitdata;
	}

	public double getLimitStorage(User user){
		double limitdata = 0;

		for (UserProduct sp : userProductService.getAvailableProduct(user.getId())){
			Product product = productService.getById(sp.getId_product()).get();
			limitdata += product.getStorage();
		}
		return limitdata;
	}

	public double getCurrentSizeStoraged(User user){
		double size = 3000000 ;
		for (UserProduct sp : userProductService.getAvailableProduct(user.getId())){
			Product product = productService.getById(sp.getId_product()).get();
			size += product.getStorage();
		}

		return size;
	}
}
