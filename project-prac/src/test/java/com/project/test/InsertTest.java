package com.project.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.project.dao.GenericDao;
import com.project.dao.ShoppingDao;
import com.project.entity.Cart;
import com.project.entity.Category;
import com.project.entity.Order;
import com.project.entity.Product;
import com.project.entity.Retailer;
import com.project.entity.User;

public class InsertTest {

	@Test
	public void addUser() {
		
		User user = new User();		
		user.setName("Ankita");
		user.setEmail("ankita@gmail");
		user.setMobileNo("9422500404");
		user.setAddress("pd road");
		user.setCity("Thane");
		user.setPincode("421202");
		user.setPassword("ankita1");
		
		GenericDao dao = new GenericDao();
		dao.save2(user);
		/*GenericDao dao = new GenericDao();
		User user = (User) dao.fetch(User.class, 1); 
		Order order = new Order();
		order.setTotalPrice(2500);
		order.setDate(LocalDate.of(2021, 04, 11));
		order.setUser(user);
		
		
		dao.save(order);*/
		
		
	}
	
	@Test
	public void fetchUser() {
		ShoppingDao dao = new ShoppingDao();
		List<User> list = dao.fetchUser(1);
		for(User u : list)
			System.out.println(u.getName() + " , " + u.getEmail() + " , " + u.getMobileNo() + " , " + u.getAddress() + " , " + u.getCity() + " , " + u.getPincode() + " , " + 
		                        u.getPassword() + " , " + u.getClass());
		
	}
	
	
	
	@Test
	public void addCategory() {
		GenericDao dao = new GenericDao();
		Category category = new Category();
		category.setName("Electronics");
		dao.save(category);
	}
	
	@Test
	public void addRetailer() {
		GenericDao dao= new GenericDao();
		
		Retailer retailer = new Retailer();
		retailer.setName("Darshit Electronics");
		retailer.setEmail("darshit@gmail.com");
		retailer.setMobileNo("9825641235");
		
		dao.save(retailer);
	}	
	
	@Test
	public void addProductThroughRetailer() {
		GenericDao dao = new GenericDao();
		Retailer retailer = (Retailer) dao.fetch(Retailer.class, 1);
		Category category = (Category) dao.fetch(Category.class, 1); 
		
		Product product = new Product();
		product.setName("hp Envy");
		product.setDescription("HP Laptop 12gb RAM ,i7Processor");
		product.setPrice(75000);
		product.setQuantity(8);
		product.setImage("d:/asset");
		product.setStatus("Available");
		product.setRetailer(retailer);
		product.setCategory(category);
		
		dao.save(product);
	}
	
	@Test
	public void fetchByCategory() {
		ShoppingDao sdao = new ShoppingDao();
		List<Product> list = sdao.displayProductOfCategory("Electronics");
		for(Product p : list)
			System.out.println(p.getName() + " , " + p.getPrice() + " , " + p.getRetailer());
	}
	
	@Test
	public void fetchByPrice() {
		ShoppingDao sdao = new ShoppingDao();
		List<Product> list = sdao.displayProductByPrice(75000);
		for(Product p : list)
			System.out.println(p.getName() + " , " + p.getPrice() + " , " + p.getStatus());
	}
}

