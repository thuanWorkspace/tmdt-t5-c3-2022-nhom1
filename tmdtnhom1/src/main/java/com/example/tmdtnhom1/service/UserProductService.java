package com.example.tmdtnhom1.service;

import com.example.tmdtnhom1.Utils.DateUtils;
import com.example.tmdtnhom1.model.Product;
import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.model.UserProduct;
import com.example.tmdtnhom1.repository.ProductRepository;
import com.example.tmdtnhom1.repository.UserProductRepository;
import com.example.tmdtnhom1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProductService {
	@Autowired
	UserProductRepository userProductRepository;

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;

	//phu
	//danh sach lich su mua san pham
	public List<UserProduct> getUserProductByUser(String id_user) {
		return userProductRepository.getUserProductByUser(id_user);
	}

	//danh sach san pham mua con han
	public List<UserProduct> getAvailableProduct(String id_user) {
		List<UserProduct> list = new ArrayList<>();
		List<UserProduct> listproduct = userProductRepository.getUserProductByUser(id_user);
		Product product;
		for(UserProduct sp : listproduct){
			product = productRepository.findById(sp.getId_product()).get();
			if (DateUtils.addDate(sp.getPurchase_date(),product.getPeriod()).after(DateUtils.currentDate())){
				list.add(sp);
			}
		}
		System.out.println("size :"+list.size());

		//bo product mua truoc neu co 2 product cung loai con han su dung
		List<UserProduct> unUsed_list = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				if (i == j) continue;
				if (list.get(i).getId_product().equalsIgnoreCase(list.get(j).getId_product())){
					UserProduct unUsed_product = list.get(i).getPurchase_date().before(list.get(j).getPurchase_date())?
							list.get(i) : list.get(j);
					unUsed_list.add(unUsed_product);
					System.out.println("remove userproduct "+unUsed_product.toString());
				}
			}
		}
		for (UserProduct up : unUsed_list){
			list.remove(up);
		}

		return list;
	}
	

	//phu
	//mua san pham
	public UserProduct orderProduct(UserProduct userProduct, int score) throws Exception {
		if (checkScoreInputProduct(userProduct.getId_user(),userProduct.getId_product(),score)){
			autoIncreseScoreWhenBuyProduct(userProduct,score);
			paymentOnline();
			return userProductRepository.save(userProduct);
		}

		return null;
	}

	public UserProduct orderProductbyScore(UserProduct userProduct) {
		/**
		 * if ( user uses convert Score to promotion ) { reduce score instead money when
		 * order }
		 */
		autoDecreseScoreWhenBuyProduct(userProduct);
		paymentOnline();
		return userProductRepository.save(userProduct);
	}

	private void autoDecreseScoreWhenBuyProduct(UserProduct userProduct) {
		User user = userRepository.findById(userProduct.getId_user()).get();
		Product product = productRepository.findById(userProduct.getId_product()).get();
		user.updateScore((int) -(product.getPrice() / User.score_factor));
		System.out.println(user.getScore());
		userRepository.save(user);
	}

	public void paymentOnline() {

	}

	public void autoIncreseScoreWhenBuyProduct(UserProduct userProduct, int score) throws Exception {
		User user = userRepository.findById(userProduct.getId_user()).get();
		Product product = productRepository.findById(userProduct.getId_product()).get();
		user.updateScore(product.getScore() - score);
		if (user.getScore() < 0) {
			throw new Exception("User Not Enough score ");
		}
		userRepository.save(user);
	}

	public UserProduct save(UserProduct userProduct) {
		return userProductRepository.save(userProduct);
	}

	public boolean checkOrderProductbyScore(UserProduct user_product) {
		try {

			Product product = productRepository.findById(user_product.getId_product()).get();
			User user = userRepository.findById(user_product.getId_user()).get();
			boolean result = user.getValueScore() < product.getPrice();
			System.out.println(result);
			if (result) {
				System.out.println(user.getValueScore() + " <false " + product.getPrice());
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public UserProduct checkAvailableProduct(String id_user, String id_product) {
		for (UserProduct up : getAvailableProduct(id_user)) {
			if (up.getId_product().equals(id_product))
				return up;
		}
		return null;
	}

	public boolean updateAvalableUserProduct(UserProduct userProduct) {
		userProduct.setAvailable(false);
		save(userProduct);

		User user = userRepository.findById(userProduct.getId_user()).get();
		Product product = productRepository.findById(userProduct.getId_product()).get();
		user.updateData(-product.getTransfer());
		userRepository.save(user);
		return true;
	}

	/*
	 * vi???t ph????ng th???c ki???m tra ??i???m c???a user v?? gi?? user truy???n v??o c?? h???p
	 * l??? ( ???????c vi???t trong service) ->kt ??i???m c?? v?????t qu?? ??i???m ng?????i d??ng ??ang c??
	 * ho???c qu?? s??? ti???n product ph???i tr???
	 */
	public boolean checkScoreInputProduct(String id_user, String id_product, int score) throws Exception {
		Product product = productRepository.findById(id_product).get();
		User user = userRepository.findById(id_user).get();

		if (user.getScore() < score){
			throw new IndexOutOfBoundsException("B???n kh??ng ????? ??i???m th?????ng ????? th???c hi???n h??nh ?????ng n??y!!");
//			return false;
		}
		if (product.getScore() < score){
			throw new NumberFormatException();//"S??? ??i???m b???n nh???p v??o v?????t qu?? gi?? tr??? c???a s???n ph???m!!");
//			return false;
		}
		return true;
	}
}
