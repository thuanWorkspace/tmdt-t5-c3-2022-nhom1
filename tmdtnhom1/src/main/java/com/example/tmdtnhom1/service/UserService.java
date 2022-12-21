package com.example.tmdtnhom1.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import com.example.tmdtnhom1.model.*;
import com.example.tmdtnhom1.repository.RoleRepository;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tmdtnhom1.repository.UserRepository;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	UserProductService userProductService;
	@Autowired
	ProductService productService;

	private String jwtSecret = "tmdtAdZ605AtgIvJBhCIc6UO72NBTdxXTOcjDv2bjY390rqfm7rTRidkefRG7RX";
	private static byte[] s256secret = new byte[32];
	//admin
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	//user
	//login by email only.
//	public User checkLogin(Login login) {
//		User user = userRepository.findByEmail(login.getEmail());
//			return user;
//	}

	public String generateJwtToken(User user) {
		Map<String, String> claims = new HashMap<>();
		claims.put("role", user.getRole());
			return Jwts.builder()
					.setClaims(claims)
					.setSubject(user.getId())
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 1*60*1000 ))
					.signWith(SignatureAlgorithm.HS256,jwtSecret)
					.compact();

//					.signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes("UTF-8"))
	}

	public String decodeJwt(String token){
		String payload = token.split("\\.")[1];
		return new String(Base64.getDecoder().decode(payload));
	}

	public TokenItem tokenItemFile(String jsonFile){
		Gson gson = new Gson();
		TokenItem tokenItem = gson.fromJson(jsonFile, TokenItem.class);
		return tokenItem;

	}

	public Optional<User> getUserByToken(String token){
		String userJson = decodeJwt(token);
		TokenItem tokenItem = tokenItemFile(userJson);
		Optional<User> userByIdToken = userRepository.findById(tokenItem.getSub());
		return userByIdToken;
	}

	public String sha256Code(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(password.getBytes());

		byte[] digest = messageDigest.digest();
		StringBuffer stringBuffer = new StringBuffer();
		for (byte b : digest){
			stringBuffer.append(String.format("%02x", b & 0xff));
		}
		return stringBuffer.toString();
	}



//	register
	public boolean checkEmailExit(Register register){
        User user = userRepository.findByEmailUser(register.getEmail());
        if(user != null){
            return true;
        }
        return false;
    }

	public User insert(User user){
		return userRepository.insert(user);
	}

	public List<Role> getRoles(){
		return roleRepository.findAll();
	}

	public List<User> getUsers(){
		return userRepository.findAll();
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


	public User findByEmail(String email) {
		List<User> list = userRepository.findByEmail(email);
		if (list.size() == 1){
			return list.get(0);
		}
		return null;
	}
}
